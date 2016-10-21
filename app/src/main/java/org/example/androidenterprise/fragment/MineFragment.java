package org.example.androidenterprise.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.*;
import org.example.androidenterprise.adapter.SettingAdapter;
import org.example.androidenterprise.view.CircleImageView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static org.example.androidenterprise.activity.LoginActivity.isLogin;

@ContentView(R.layout.fragment_mine)

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MineFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MineFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @ViewInject(R.id.ib_search)
    ImageButton searchIb;
    @ViewInject(R.id.civ_mine)
    CircleImageView mineCIv;
    @ViewInject(R.id.tv_mine_name)
    TextView nameTv;
    @ViewInject(R.id.tv_mine_phone)
    TextView phoneTv;
    @ViewInject(R.id.lv_mine_setting)
    ListView settingLv;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Class> jumpActivityList;

    private OnFragmentInteractionListener mListener;

    public MineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        settingLv = (ListView) view.findViewById(R.id.lv_mine_setting);
        searchIb = (ImageButton) view.findViewById(R.id.ib_search);

        jumpActivityList = new ArrayList<Class>() {
            {
                add(OrderActivity.class);
                add(RecordActivity.class);
                add(MessageActivity.class);// TODO: 2016/10/16 add MessageActivity to this line
                add(MyWorksActivity.class);// TODO: 2016/10/16 add WorkActivity to this line
                add(ComplainSuggestActivity.class);
                add(ContactUsActivity.class);
                add(HelpCenterActivity.class);
            }
        };

        if (!isLogin) {
            mineCIv.setImageResource(R.drawable.ic_head_default);
            nameTv.setText("未登录");
            phoneTv.setVisibility(View.INVISIBLE);
        } else {
            mineCIv.setImageResource(R.drawable.img_example2);
            nameTv.setText("2333333");
            phoneTv.setText("23333333");
            phoneTv.setVisibility(View.VISIBLE);
        }

        SettingAdapter settingAdapter = new SettingAdapter(getContext());
        settingLv.setAdapter(settingAdapter);

        settingLv.setOnItemClickListener(this);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        if(!isLogin && position != 4 && position != 5 && position != 6){
            Toast.makeText(getContext(), "请先登录", Toast.LENGTH_LONG).show();
            intent.setClass(getContext(), LoginActivity.class);
        }else{
            intent.setClass(getContext(), jumpActivityList.get(position));
        }
        startActivity(intent);
    }

    @Event(value = {R.id.ib_search, R.id.civ_mine})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_search:
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            case R.id.civ_mine:
                startActivity(new Intent(getContext(), PortraitActivity.class));
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
