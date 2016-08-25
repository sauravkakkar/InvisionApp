package com.devfusion.saurav.invision;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;

/*import android.support.v7.internal.view.ContextThemeWrapper;*/
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class AfterLogin extends Activity {

    Dialog dialog;
    ImageView imv_profile,back,imv_1,imv_2,imv_3;
    ImageView imv_temp,imv_11,imv_22,imv_33;
    TextView tv_temp,tv_model,tv_actress,tv_designer;
    Button bt_save,btn_skill;
    TextInputLayout input_layout_name,input_layout_eyecolor,input_layout_age,input_layout_height,input_layout_weight,input_layout_haircolor,input_layout_language,input_layout_summary;
    EditText inputName,inputEyeColor,inputAge,input_height,input_weight,input_haircolor,input_language,input_summary;

    RelativeLayout rl_imv1,rl_imv2,rl_imv3;
    private static final int CAMERA_CAPTURE = 0;
    private static final int IMAGE_GET = 1;
    private static final int PIC_CROP = 2;
    private String userChoosenTask;
    private String _imageCapturedName = null;
    private File fileName = null;
   // private static final int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    Uri picUri;
    Bitmap photo;
    String image="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_login);
       // getSupportActionBar().hide();

        bt_save=(Button)findViewById(R.id.bt_save);
        btn_skill=(Button)findViewById(R.id.btn_skill);

        tv_model=(TextView)findViewById(R.id.tv_model);
        tv_actress=(TextView)findViewById(R.id.tv_actress);
        tv_designer=(TextView)findViewById(R.id.tv_designer);

        input_layout_name= (TextInputLayout)findViewById(R.id.input_layout_name);
        input_layout_eyecolor= (TextInputLayout)findViewById(R.id.input_layout_eyecolor);
        input_layout_age= (TextInputLayout)findViewById(R.id.input_layout_age);
        input_layout_height= (TextInputLayout)findViewById(R.id.input_layout_height);
        input_layout_weight= (TextInputLayout)findViewById(R.id.input_layout_weight);
        input_layout_haircolor= (TextInputLayout)findViewById(R.id.input_layout_haircolor);
        input_layout_language= (TextInputLayout)findViewById(R.id.input_layout_language);
        input_layout_summary= (TextInputLayout)findViewById(R.id.input_layout_summary);

        inputName = (EditText)findViewById(R.id.input_name);
        inputEyeColor = (EditText)findViewById(R.id.input_eyecolor);
        inputAge = (EditText)findViewById(R.id.input_age);
        input_height = (EditText)findViewById(R.id.input_height);
        input_weight = (EditText)findViewById(R.id.input_weight);
        input_haircolor = (EditText)findViewById(R.id.input_haircolor);
        input_language = (EditText)findViewById(R.id.input_language);
        input_summary = (EditText)findViewById(R.id.input_summary);

      //  inputName.addTextChangedListener(new MyTextWatcher(inputName));
      //  inputEyeColor.addTextChangedListener(new MyTextWatcher(inputEyeColor));
      //  inputAge.addTextChangedListener(new MyTextWatcher(inputAge));



        imv_profile = (ImageView)findViewById(R.id.imv_profile);
        imv_1=(ImageView)findViewById(R.id.imv_1);
        imv_2=(ImageView)findViewById(R.id.imv_2);
        imv_3=(ImageView)findViewById(R.id.imv_3);
        back = (ImageView)findViewById(R.id.back);

        imv_temp=(ImageView)findViewById(R.id.imv_temp);
        imv_11=(ImageView)findViewById(R.id.imv_11);
        imv_22=(ImageView)findViewById(R.id.imv_22);
        imv_33=(ImageView)findViewById(R.id.imv_33);

        tv_temp=(TextView)findViewById(R.id.tv_temp);

        rl_imv1=(RelativeLayout)findViewById(R.id.rl_imv1);
        rl_imv2=(RelativeLayout)findViewById(R.id.rl_imv2);
        rl_imv3=(RelativeLayout)findViewById(R.id.rl_imv3);
       // showAlertDialog(AfterLogin.this,"" +"", "Are you sure, You wanted to make decision", false);


        imv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // dialog = new Dialog(new ContextThemeWrapper(getApplicationContext(), R.style.DialogSlideAnim));
                image="imv_profile";
                selectImage();
            }
        });
        imv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image="imv_1";
                selectImage();
            }
        });
        imv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image="imv_2";
                selectImage();
            }
        });
        imv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image="imv_3";
                selectImage();
            }
        });


        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //select();
                Intent intent =new Intent(getApplicationContext(),SkillActivity.class);
                startActivity(intent);
            }
        });
    }//on create


 /*     @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                    {
                        // cameraIntent();
                        System.out.println("onRequestPermissionsResult");
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent,CAMERA_CAPTURE);
                    }

                    else if(userChoosenTask.equals("Choose from Library"))
                    {
                        // galleryIntent();
                        System.out.println("userChoosenTask");
                        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, IMAGE_GET);
                    }

                } else {
                    //code for deny
                }
                break;
        }
    }*/


    private void selectImage() {
        AlertDialog.Builder srch = new AlertDialog.Builder(AfterLogin.this);
        srch.setTitle("Add Photo!");
        srch.setItems(R.array.prflPic,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        // TODO Auto-generated method stub
                        Log.v("Log","search select value: "+ String.valueOf(which));
                        switch (which) {
                            case 0:
                                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                /*cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());*/
                                startActivityForResult(cameraIntent,CAMERA_CAPTURE);


                              //----------------------------

                               /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                _imageCapturedName = "Image_"
                                        + String.valueOf(System.currentTimeMillis());
                                fileName = ThemedSpinnerAdapter.Helper.createFileInSDCard(ThemedSpinnerAdapter.Helper.getTempFile()
                                        + "=TestFolder/", _imageCapturedName + ".JPG");

                                intent = new Intent("android.media.action.IMAGE_CAPTURE").putExtra(
                                        android.provider.MediaStore.EXTRA_OUTPUT,
                                        Uri.fromFile(new File(fileName.toString())));*/



                                break;
                            case 1:
                                /*Intent intent = new Intent();
                                intent.setType("image*//* ");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent,"Select Image"), IMAGE_GET);*/

                                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(i, IMAGE_GET);
                                break;
                        }
                    }
                });
        srch.show();
    }

   /* private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image*//**//**//**//*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);


    //Pick Image From Gallery
    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    startActivityForResult(i, SELECT_FILE);

    }*/

    /*private void cameraIntent()
    {
        *//*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
        startActivityForResult(intent, REQUEST_CAMERA);*//*

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,REQUEST_CAMERA);


    }*/

    private void select() {
        final CharSequence[] items={"Model","Actress","Designer","Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(AfterLogin.this);
        builder.setTitle("Add Skill!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(AfterLogin.this);

                if (items[item].equals("Model")) {
                tv_model.setVisibility(View.VISIBLE);
                } else if (items[item].equals("Actress")) {
                   tv_actress.setVisibility(View.VISIBLE);
                }else if (items[item].equals("Designer")) {
                    tv_designer.setVisibility(View.VISIBLE);
                }else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_CAPTURE:
                if (resultCode == RESULT_OK ) {
                    picUri = data.getData();
                    System.out.println("---picUri----" + picUri);
                    performCrop();

                                    }
                break;
            case IMAGE_GET:
                if (resultCode == RESULT_OK) {
                    picUri = data.getData();
                    System.out.println("uri path---->" + picUri);
                    performCrop();
                    //-----------------------------          OR------------
                   /* Bitmap bm=null;
                    if (data != null) {
                        try {
                            bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    imv_profile.setImageBitmap(bm);*/
                }
                break;
            case PIC_CROP:
                try {
                   // if (set_coverimage.equals("cover_image"))
                    {
                        Bundle extras = data.getExtras();
                        Bitmap bmp = extras.getParcelable("data");
                        ContentValues values = new ContentValues();
                        Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                        System.out.println("uri.........>"+uri);
                        photo = (Bitmap) data.getExtras().get("data");
                        System.out.println("photo------------>"+photo);
                        if(image=="imv_profile") {

                            imv_profile.setImageBitmap(photo);
                            imv_temp.setVisibility(View.GONE);
                            tv_temp.setVisibility(View.INVISIBLE);
                        }
                        else if(image=="imv_1") {
                            imv_1.setImageBitmap(photo);
                            rl_imv1.setBackgroundResource(0);
                            imv_11.setVisibility(View.GONE);
                        }
                        else if(image=="imv_2") {
                            imv_2.setImageBitmap(photo);
                            rl_imv2.setBackgroundResource(0);
                            imv_22.setVisibility(View.GONE);
                        }
                        else if(image=="imv_3") {
                            imv_3.setImageBitmap(photo);
                            rl_imv3.setBackgroundResource(0);
                            imv_33.setVisibility(View.GONE);
                        }

                       /* OutputStream outstream;
                        try {
                            outstream = getContentResolver().openOutputStream(uri);
                            System.out.println("outstream//////////>"+outstream);
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            photo.compress(Bitmap.CompressFormat.PNG, 100, baos);
                            byte[] b = baos.toByteArray();
                            if(cover_image1.equals(" ")){
                                System.out.println("------blank image -cover_image1----");
                            }else
                            {
                                encodedImageCover = Base64.encodeToString(b,Base64.NO_WRAP)*//*.replace("+","%20")*//*;
                                System.out.println("encodedImageCover=------------>"+encodedImageCover);
                                outstream.close();
                                selectpath = getPath(uri);
                                System.out.println("selectpath---->>>"+selectpath);
                                imv_profile.setImageBitmap(photo);
                            }
                        }catch (FileNotFoundException e) {
                        } catch (IOException e) {
                        }*/
                    }
                    /*if (set_coverimage.equals("profile_image")) {
                        Bundle extras = data.getExtras();
                        Bitmap bmp = extras.getParcelable("data");
                        ContentValues values = new ContentValues();
                        Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                        photo = (Bitmap) data.getExtras().get("data");
                        OutputStream outstream;
                        try {
                            outstream = getContentResolver().openOutputStream(uri);
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            photo.compress(Bitmap.CompressFormat.PNG, 100, baos);
                            byte[] b = baos.toByteArray();
                            if(profile_image.equals(" ")){
                                System.out.println("------blank image-profile_image----");
                            }else
                            {
                                encodedImageProfile = Base64.encodeToString(b,Base64.NO_WRAP)*//*.replace("+","%20")*//*;
                                outstream.close();
                                selectpath = getPath(uri);
                                System.out.println("selectpath---->>>"+selectpath);
                                profile_image.setImageBitmap(bmp);
                                File f = new File(picUri.getPath());
                                System.out.println("file mame---->"+f);
                                if (f.exists())
                                    f.delete();
                            }
                        } catch (FileNotFoundException e) {

                        } catch (IOException e) {
                        }
                    }*/
                } catch (NullPointerException e) {
                }
                break;
            default:
                break;
        }
    }

    private void performCrop() {
        // take care of exceptions
        try {
            // call the standard crop action intent (the user device may not
            // support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            // indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            // set crop properties
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, PIC_CROP);
            // take care of exceptions

        } catch (ActivityNotFoundException anfe) {
            // display an error message
            String errorMessage = "Whoops - your device doesn't support the crop action!";
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    private void submitForm() {
       /* if (!validateName()) {return;}
        if (!validateEye()){return;}
        if(!validateAge()){return;}
        if (!validateHeight()){return;}
        if (!validateWeight()){return;}
        if (!validateHair()) {return;}*/
       /* if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }*/

       // Toast.makeText(getApplicationContext(), "Form Submitted !", Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(AfterLogin.this,DetailActivity.class);
        startActivity(intent);
    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            input_layout_name.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            input_layout_name.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEye() {
        if(inputEyeColor.getText().toString().trim().isEmpty()) {
            input_layout_eyecolor.setError(getString(R.string.err_msg_eyecolor));
            requestFocus(inputEyeColor);
            return false;
        }else{
            input_layout_eyecolor.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateHair() {
        if(input_haircolor.getText().toString().trim().isEmpty()) {
            input_layout_haircolor.setError("Enter hair color..");
            requestFocus(input_haircolor);
            return false;
        }else{
            input_layout_haircolor.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateHeight() {
        if(input_height.getText().toString().trim().isEmpty()) {
            input_layout_height.setError("Enter height..");
            requestFocus(input_height);
            return false;
        }else{
            input_layout_height.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateWeight() {
        if(input_weight.getText().toString().trim().isEmpty()) {
            input_layout_weight.setError("Enter weight..");
            requestFocus(input_weight);
            return false;
        }else{
            input_layout_weight.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateAge() {
        if(inputAge.getText().toString().trim().isEmpty()) {
            input_layout_age.setError("Enter age..");
            requestFocus(inputAge);
            return false;
        }else{
            input_layout_age.setErrorEnabled(false);
        }
        return true;
    }

   /* private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }*/

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_eyecolor:
                    validateEye();
                    break;
                case R.id.input_age:
                    validateAge();
                    break;
            }
        }
    }


    public void showAlertDialog(Context context, String title, String message, Boolean status)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                //finish();
            }
        });
        alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //your <code></code>
                onBackPressed();
            }
        });
        alertDialog.show();
    }
}
