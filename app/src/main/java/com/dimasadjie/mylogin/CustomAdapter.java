package com.dimasadjie.mylogin;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] items;
    private int[] images;
    private String[] names;
    private String[] numbers;
    private String[] addresses;

    public CustomAdapter(Context context, String[] items, int[] images, String[] names, String[] numbers, String[] addresses) {
        super(context, R.layout.list_item_with_image, items);
        this.context = context;
        this.items = items;
        this.images = images;
        this.names = names;
        this.numbers = numbers;
        this.addresses = addresses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_with_image, parent, false);

        TextView textViewItem = view.findViewById(R.id.textViewItem);
        ImageView imageView = view.findViewById(R.id.imageView);

        textViewItem.setText(items[position]);
        imageView.setImageResource(images[position]);

        return view;
    }

    public String getItemName(int position) {
        return names[position];
    }

    public String getItemNumber(int position) {
        return numbers[position];
    }

    public String getItemAddress(int position) {
        return addresses[position];
    }
}
