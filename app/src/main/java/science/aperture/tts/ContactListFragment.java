package science.aperture.tts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import science.aperture.tts.datahandling.Contact;
import science.aperture.tts.datahandling.ContactAdapter;

import static android.app.Activity.RESULT_OK;

public class ContactListFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;
//
    public ContactListFragment() {
        // Required empty public constructor
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    ArrayList<Contact> contactList;
    ContactAdapter contactAdapter;
    ListView contactListView;
    public static int RESULT_CODE = 101;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        contactList = new ArrayList<>();
        contactList.add(new Contact("Example1", "0811632100"));
        contactList.add(new Contact("Example2", "0812512300"));
        contactList.add(new Contact("Example3", "0813432100"));
        contactList.add(new Contact("Example4", "0814332100"));
        contactList.add(new Contact("Example5", "0815212300"));
        contactList.add(new Contact("Example6", "0816132100"));
        contactList.add(new Contact("Example7", "0817012300"));
        contactList.add(new Contact("Example8", "0818932100"));

        contactListView = view.findViewById(R.id.contact_list_view);
        contactAdapter = new ContactAdapter(contactList);
        contactListView.setAdapter(contactAdapter);

        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = (Contact) contactAdapter.getItem(position);
                Toast.makeText(view.getContext(), contact.getName(), Toast.LENGTH_LONG).show();

                ContactDetailsFragment.name.setText(contact.getName());
                ContactDetailsFragment.number.setText(contact.getNumber());
            }
        });

//        view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listProduct.size() > 0) {
//                    int productpost = 0;
//                    listProduct.remove(productpost);
//                    productListViewAdapter.notifyDataSetChanged();
//                }
//            }
//        });

        view.findViewById(R.id.add_contact_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), AddContactActivity.class), RESULT_CODE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == RESULT_CODE) {
//            if (resultCode == RESULT_OK) {
                Toast.makeText(getContext(), data.getStringExtra(AddContactActivity.EXTRA), Toast.LENGTH_LONG).show();
//            }
//        }
    }

    //    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
