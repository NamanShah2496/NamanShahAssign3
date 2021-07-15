package naman.shah.n01392496.ui.main;
// Naman Shah, N01392496, RNA

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

import naman.shah.n01392496.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class NamanFragment extends Fragment {
    private static final String TAG = "1";
    private View v;
    String website="https://www.linkedin.com/feed/";
    private PageViewModel pageViewModel;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Intent intent = null;

    public static NamanFragment newInstance() {

        return new NamanFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_naman, container, false);
        final TextView textView = v.findViewById(R.id.section_label);
        pageViewModel.getText().observe(getViewLifecycleOwner(),
                s -> textView.setText(s));


        final ImageButton btn = v.findViewById(R.id.namanimageButton);
        final Button button = v.findViewById(R.id.namanbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                if (count > 2) {
                    count = 0;

                }
                if (count == 0){
                    btn.setImageResource(R.drawable.fn);
                }
                if (count == 1) {
                    btn.setImageResource(R.drawable.three);
                }
                if (count == 2){
                    btn.setImageResource(R.drawable.one);
                }
                 count++;
            }
        });
        button.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();

            DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                    mDateSetListener, cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
            dialog.show();
        });
        mDateSetListener = (view, year, month, day) -> {

                    month = month + 1;
            ConstraintLayout rootlayout = (ConstraintLayout) v.findViewById(R.id.constraintLayout);
            Snackbar snackbar = Snackbar
                    .make(rootlayout, +  month + "/" + day + "/" + year, Snackbar.LENGTH_LONG)
                    .setAction("Click", view1 -> {
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(website));
                        startActivity(intent);

                    });

            snackbar.show();
        };
    return v;
    }
}


