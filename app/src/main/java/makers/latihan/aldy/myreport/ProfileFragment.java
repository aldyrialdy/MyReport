package makers.latihan.aldy.myreport;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    ImageView imgProfile;
    Button btnTake, btnRemove;
    TextView txtName, txtSubject;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myfragment = inflater.inflate(R.layout.fragment_profile, container, false);

        imgProfile = (ImageView) myfragment.findViewById(R.id.imgPhoto);
        btnTake = (Button) myfragment.findViewById(R.id.btnTake);
        btnRemove = (Button) myfragment.findViewById(R.id.btnEdit);
        txtName = (TextView) myfragment.findViewById(R.id.txtName);
        txtSubject = (TextView) myfragment.findViewById(R.id.txtWork);

        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                imgProfile.setImageBitmap(null);
                imgProfile.destroyDrawingCache();
            }
        });

        txtName.setText("Aldy Rialdy");
        txtSubject.setText("Makers Institute");

        // Inflate the layout for this fragment
        return myfragment;
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // intent to camera
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) { // check if camera is available
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE); // running the intent
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) { // check if the request code is from camera and if the result is ok
            Bundle extras = data.getExtras(); // getting data from the camera
            Bitmap imageBitmap = (Bitmap) extras.get("data"); // assign the data, which is a picture to a variable
            imgProfile.setImageBitmap(imageBitmap); // applying the picture into an ImageView
        }
    }

}
