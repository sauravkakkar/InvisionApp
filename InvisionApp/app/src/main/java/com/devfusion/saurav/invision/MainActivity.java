package com.devfusion.saurav.invision;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;

import soundcloud.SoundCloud;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    Button btnSigIn;
    TextView tv_signup;
    private EditText inputEmail, inputPassword;
  //  private TextInputLayout inputLayoutEmail, inputLayoutPassword;
    private Button bt_logout,bt_disconnect;
    VideoView vv;


    //Signin button
    private SignInButton signInButton;

    //Signing Options
    private GoogleSignInOptions gso;

    //google api client
    private GoogleApiClient mGoogleApiClient;

    //Signin constant to check the activity result
    private int RC_SIGN_IN = 100;


    //TextViews
    private TextView textViewName;
    private TextView textViewEmail;
    private NetworkImageView profilePhoto;
    //Image Loader
    private ImageLoader imageLoader;
  //  ApiWrapper wrapper;
//-----------------------------Fb integration-----------
  private LoginButton loginButton;
    private ShareDialog shareDialog;
  private int FB_SIGN_IN = 101;
  private CallbackManager callbackManager = null;
    private AccessTokenTracker mtracker = null;
    private ProfileTracker mprofileTracker = null;
    //------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


      //  facebook = (Button) findViewById(R.id.facebook);
        btnSigIn = (Button) findViewById(R.id.btn_signup);
        bt_logout=(Button)findViewById(R.id.bt_logout);
        bt_disconnect=(Button)findViewById(R.id.bt_disconnect);

        tv_signup=(TextView)findViewById(R.id.tv_signup);
        /*inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);*/

        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);


        String text = "<font color=#cfcfcf>Don't have an account? </font> <font color=#FFFFFF> <b>Sign up</b></font>";
        tv_signup.setText(Html.fromHtml(text));


        //------------------------------FB Integration----------------
        /*shareDialog = new ShareDialog(this);

        ShareLinkContent content = new ShareLinkContent.Builder().build();
        shareDialog.show(content);*/

        callbackManager = CallbackManager.Factory.create();
        mtracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

                Log.v("AccessTokenTracker", "oldAccessToken=" + oldAccessToken + "||" + "CurrentAccessToken" + currentAccessToken);
            }
        };
        mprofileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {


                Log.v("Session Tracker", "oldProfile=" + oldProfile + "||" + "currentProfile" + currentProfile);
                nextActivity(currentProfile);
            }
        };
        mtracker.startTracking();
        mprofileTracker.startTracking();

        loginButton = (LoginButton)findViewById(R.id.login_button_facebook);
        //Facebook login button
        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                nextActivity(profile);
                Toast.makeText(getApplicationContext(), "Logging in..."+profile.getFirstName()+" "+profile.getLastName(), Toast.LENGTH_SHORT).show();    }
            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        };
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, callback);

//--------------------------------------------------------------------------------------------
        //Initializing Views
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        profilePhoto = (NetworkImageView) findViewById(R.id.profileImage);

        //Initializing google signin option
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.PLUS_LOGIN))
                .requestEmail()
                .build();

        //Initializing signinbutton
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(gso.getScopeArray());

        //Initializing google api client
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating an intent
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);

                //Starting intent for result
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mGoogleApiClient.isConnected()) {
                    Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                            new ResultCallback<Status>() {
                                @Override
                                public void onResult(Status status) {
                                    // ...
                                    Toast.makeText(getApplicationContext(),"logout successfully..."+status,Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login first..",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(Status status) {
                                // ...
                                Toast.makeText(getApplicationContext(),"Disconnect successfully..."+status,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


        //---------------------------------------------------------------------------

        vv=(VideoView)findViewById(R.id.myvideo);
        vv.setVideoPath("android.resource://"+getPackageName()+"/" + R.raw.splash);
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp) {
                /*Intent in=new Intent(splash.this,MainActivity.class);
                startActivity(in);
                finish();*/
                vv.start();
            }
        });
        vv.start();





        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });

        btnSigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

    }//on create

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //If signin
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //Calling a new function to handle signin
            handleSignInResult(result);
        }
        else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        mtracker.stopTracking();
        mprofileTracker.stopTracking();
    }
    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (isLoggedIn()) {
            Profile  profile = Profile.getCurrentProfile();
           // nextActivity(profile);

        }

    }
    private void nextActivity(Profile profile){
        if(profile != null){
            System.out.println("if case-->");
            System.out.println("name-->"+profile.getFirstName());
            System.out.println("name-->"+profile.getCurrentProfile());
            System.out.println("surname"+ profile.getLastName());
            Intent main = new Intent(getApplicationContext(), DetailActivity.class);
            main.putExtra("name", profile.getFirstName());
            main.putExtra("surname", profile.getLastName());
            main.putExtra("imageUrl", profile.getProfilePictureUri(200,200).toString());
            startActivity(main);
        }
        else{
            System.out.println("else case-->");
            Profile profile1 = Profile.getCurrentProfile();
            System.out.println("name-->"+profile1.getFirstName());
            System.out.println("name-->"+profile1.getCurrentProfile());
            System.out.println("surname"+ profile1.getLastName());
        }
    }

    //After the signing we are calling this function
    private void handleSignInResult(GoogleSignInResult result) {
        //If the login succeed
        if (result.isSuccess()) {
            //Getting google account
            GoogleSignInAccount acct = result.getSignInAccount();

            //Displaying name and email
            textViewName.setText(acct.getDisplayName());
            textViewEmail.setText(acct.getEmail());
            String photourl= ""+acct.getPhotoUrl();
            System.out.println("photourl---"+photourl);
            System.out.println("getId is....>"+acct.getId());
            System.out.println("getIdToken is....>"+acct.getIdToken());
            System.out.println("getPhotoUrl()-----> "+acct.getPhotoUrl());

            if(acct.getPhotoUrl()==null){
                System.out.println("enter if case-->");
                profilePhoto.setDefaultImageResId(R.drawable.gallery2);
                profilePhoto.setErrorImageResId(R.drawable.gallery2);
            }
            else {
                //Initializing image loader
                imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext()).getImageLoader();

                imageLoader.get(acct.getPhotoUrl().toString(), ImageLoader.getImageListener(profilePhoto,
                        R.mipmap.ic_launcher, R.mipmap.ic_launcher));

                //Loading image
                profilePhoto.setImageUrl(acct.getPhotoUrl().toString(), imageLoader);
                /*Intent intent = new Intent(getApplicationContext(), AfterLogin.class);
                startActivity(intent);*/
            }
        } else {
            //If login fails
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    private void submitForm() {
      /*  if (!validateEmail()) {
            return;
        }
        if (!validatePassword()) {
            return;
        }*/
        vv.stopPlayback();
        Intent intent = new Intent(getApplicationContext(), AfterLogin.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Login Successfully!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
           // inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } //else {inputLayoutEmail.setErrorEnabled(false);}
        return true;
    }
    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
          //  inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        }// else {inputLayoutPassword.setErrorEnabled(false);}
        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
