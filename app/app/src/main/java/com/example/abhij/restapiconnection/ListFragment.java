package com.example.abhij.restapiconnection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    RecyclerView recyclerViewList;
    ArrayList<Student> studentArrayList;
    RecyclerAdapter adapter;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list, container, false);

        recyclerViewList = view.findViewById(R.id.recylerView_list);
        studentArrayList = (ArrayList<Student>) getArguments().getSerializable("list");

        adapter = new RecyclerAdapter(getContext(), studentArrayList, new RecyclerAdapter.OnItemClickedListener() {
            @Override
            public void onClick(int position) {

            }
        });


        recyclerViewList.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerViewList.setAdapter(adapter);

        return view ;

    }

}
