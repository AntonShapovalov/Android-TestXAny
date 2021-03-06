package test.list.api;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private final String[] packagePrefix = {
            "accelerometr.",
            "canvas.",
            "orientation.",
            "imageview.",
            "animation.",
            "plotbuilder."
    };
    private final String[] classNames = {
            "AccelerometrActivity",
            "RenderActivity",
            "OrientationActivity",
            "ImageviewActivity",
            "PropertyAnimation",
            "PlotActivity"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classNames));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        try {
            String packageName = "test.list.api.";
            Class<?> clas = Class.forName(packageName + packagePrefix[position] + classNames[position]);
            Intent intent = new Intent(this, clas);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
