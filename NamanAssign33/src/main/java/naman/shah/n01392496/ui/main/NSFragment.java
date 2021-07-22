// Naman Shah, N01392496, RNA
package naman.shah.n01392496.ui.main;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;
import naman.shah.n01392496.R;

public class NSFragment extends Fragment {
private View v;
    private static final int REQUEST_PHONE_CALL = 1;

    public NSFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_n_s, container, false);
        // Inflate the layout for this fragment
        final Button button = v.findViewById(R.id.namanbutton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDummyContactWrapper();
            }
        });
return v;
    }
    private void insertDummyContactWrapper() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse(getString(R.string.tel) + getString(R.string.number)));
            requireActivity().startActivity(callIntent);
        } else {
            ActivityCompat.requestPermissions((Activity) requireContext(), new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_PHONE_CALL);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        if (requestCode == REQUEST_PHONE_CALL && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getContext(), getResources().getString(R.string.allow), Toast.LENGTH_SHORT).show();
        }
        else if(requestCode != REQUEST_PHONE_CALL && grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED){
            ConstraintLayout text = (ConstraintLayout) v.findViewById(R.id.constraintLayout);
            Snackbar snackbar = Snackbar
                    .make(text, R.string.deny, Snackbar.LENGTH_LONG);
                    snackbar.show();
        }
    }
}