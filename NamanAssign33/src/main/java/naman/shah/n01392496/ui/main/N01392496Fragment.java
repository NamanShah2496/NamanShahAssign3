// Naman Shah, N01392496, RNA
package naman.shah.n01392496.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import naman.shah.n01392496.R;


public class N01392496Fragment extends Fragment {

    public Switch toggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_n01392496, container, false);
        // Inflate the layout for this fragment
        toggle = view.findViewById(R.id.switch1);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onToggle(v);
            }
        });
        return view;
    }

    public void onToggle(View v){
        Context context = getActivity().getApplicationContext();
        if(toggle.isChecked()){
            Toast.makeText(context, getString(R.string.toggle_on),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, getString(R.string.toggle_off),Toast.LENGTH_SHORT).show();
        }
    }
}