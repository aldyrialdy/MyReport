package makers.latihan.aldy.myreport;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {
    TextView averageScoreText, scoreDescriptionText;
    Button myScoreButton;

    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myFragment = inflater.inflate(R.layout.fragment_summary, container, false);

        averageScoreText = (TextView) myFragment.findViewById(R.id.txtScore);
        scoreDescriptionText = (TextView) myFragment.findViewById(R.id.txtDegree);
        myScoreButton = (Button) myFragment.findViewById(R.id.btnMyScore);

        myScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ScoreActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return myFragment;
    }

}
