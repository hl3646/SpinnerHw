package com.example.spinnerhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    ListView lv;
    Spinner spin;
    TextView tv1, tv2, tv3, tv4;
    int rowOfClass;

    String[][] privateNames = {{"Harel", "Inbar", "Orel", "Erel", "Dorel", "Dan", "Nisim", "Idan", "Shay", "Yonatan"},
                               {"Lamar", "Josh", "Joe", "Deshaun", "Russell", "Davis", "Matt", "Trevor", "Patrick", "Derek"},
                               {"Justin", "Tua", "Mac", "Mike", "Kenny", "Ryan", "Marcus", "Kyler", "Sam", "Justin"},
                               {"Dak", "Jared", "Aaron", "Matthew", "Kirk", "Andy", "Daniel", "Jalen", "Jimmy", "Tom"}};

    String[][] lastNames = {{"Levi", "Menahem", "Gabai", "Ben-Baruch", "Guedge", "Zhuravlov", "Krief", "Bunkin", "Shtayman", "eiluz"},
                            {"Jackson", "Allen", "Burrow", "Watson", "Wilson", "Mills", "Ryan", "Lawrence", "Mahomes", "Carr"},
                            {"Herbert", "Tagovailoa", "Jones", "White", "Pickett", "Tennehill", "Mariota", "Murray", "Darnold", "Fields"},
                            {"Prescott", "Goff", "Rodgers", "Stafford", "cousins", "Dalton", "Jones", "Hurts", "Garoppolo", "Brady"}};

    String[][] birthDates = {{"29/10/2006", "17/06/2006", "21/08/2006", "23/12/2006", "24/06/2006", "15/04/2006", "30/11/2006", "24/09/2006", "14/01/2006", "18/07/2006"},
                             {"07/01/1997", "21/05/1996", "10/12/1996", "14/09/1995", "29/11/1988", "21/10/1998", "17/05/1985", "06/10/1999", "17/09/1995", "28/03/1991"},
                             {"10/03/1998", "02/03/1998", "05/09/1998", "25/03/1995", "06/06/1998", "27/07/1988", "80/10/1993", "07/08/1997", "05/06/1997", "05/05/1999"},
                             {"19/07/1993", "14/10/1994", "02/12/1983", "07/02/1988", "19/08/1988", "29/10/1987", "27/05/1997", "07/08/1998", "02/11/1991", "03/08/1977"}};

    String[][] phoneNumbers = {{"0584779384", "0547456674", "0587161658", "0522228615", "0586910852", "0586651505", "0542509918", "0544771608", "0532230985", "0502120264"},
                               {"0523456328", "0567392810", "0532794881", "0549300219", "0544448392", "0529100273", "0547773829", "0548884832", "0536463523", "0566667749"},
                               {"0542312390", "0512345678", "0566739023", "0564663773", "0505747839", "0567778392", "0532182902", "0593020123", "0587392009", "0544337289"},
                               {"0546288192", "0574882930", "0563781923", "0543213302", "0567894930", "0585849302", "0594920332", "0566479929", "0504032013", "0059933721"}};

    String[] classes = {"choose class", "class 1", "class 2", "class 3", "class 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.ListView);
        tv1 = (TextView) findViewById(R.id.TV);
        tv2 = (TextView) findViewById(R.id.TV2);
        tv3 = (TextView) findViewById(R.id.TV3);
        tv4 = (TextView) findViewById(R.id.TV4);
        spin = (Spinner) findViewById(R.id.spinner);

        //creating an adapter for the spinner and connecting it
        ArrayAdapter<String> spinAdp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, classes);
        spin.setAdapter(spinAdp);

        // connecting the listener to the actual spinner
        spin.setOnItemSelectedListener(this);

        // connecting the listener to the list view
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        if(i > 0) // a class has been chosen
        {
            rowOfClass = i - 1; // getting the index of the array of the chosen class
            // connecting the adapter of the chosen class to the list view
            ArrayAdapter<String> listAdp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, privateNames[rowOfClass]);
            lv.setAdapter(listAdp);
        }
        else // a class hasn't been chosen
        {
            // throwing a toast and connecting an empty adapter to the list view since the chosen option isn't a class
            Toast.makeText(getApplicationContext(),"Please select a class", Toast.LENGTH_SHORT).show();
            ArrayAdapter<String> listAdp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            lv.setAdapter(listAdp);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {
        Toast.makeText(getApplicationContext(),"Please select a class", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        // setting the info about the chosen student from the listview from the arrays to the textviews
        tv1.setText(privateNames[rowOfClass][i]);
        tv2.setText(lastNames[rowOfClass][i]);
        tv3.setText(birthDates[rowOfClass][i]);
        tv4.setText(phoneNumbers[rowOfClass][i]);
    }
}