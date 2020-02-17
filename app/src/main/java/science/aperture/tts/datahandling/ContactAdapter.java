package science.aperture.tts.datahandling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import science.aperture.tts.R;

public class ContactAdapter extends BaseAdapter {
    ArrayList<Contact> listContact;

    public ContactAdapter(ArrayList<Contact> listProduct) {
        this.listContact = listProduct;
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int position) {
        return listContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.contact_list_row_layout, null);
        } else viewProduct = convertView;

        Contact contact = (Contact) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.contact_name)).setText(contact.getName());
        ((TextView) viewProduct.findViewById(R.id.contact_number)).setText(contact.getNumber());

        return viewProduct;
    }
}
