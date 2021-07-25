package android.example.schoolify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.List;

public class SubjectListAdapter extends ArrayAdapter<Subjects> {

    private final Context mContext;
    int mResource;

    public SubjectListAdapter(@NonNull Context context, int resource, List<Subjects> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String subject = getItem(position).getSubject();

        Subjects subj = new Subjects(subject);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = convertView.findViewById(R.id.subject_name);

        tvName.setText(subject);

        return convertView;
    }

}
