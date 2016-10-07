package org.example.androidenterprise.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.CourseInfoActivity;
import org.example.androidenterprise.activity.SearchActivity;
import org.example.androidenterprise.adapter.CourseAdapter;
import org.example.androidenterprise.utils.AutoPlayInfo;
import org.example.androidenterprise.view.AutoPlayingViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CourseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView course_list;
    private int[] imagesCourse;
    private AutoPlayingViewPager courseAutoVP;
    private String[] imageTitle;
    private List<AutoPlayInfo> mAutoPlayInfoList;
    private ImageButton searchBtn;


    private OnFragmentInteractionListener mListener;

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course,container,false);
        course_list = (ListView) view.findViewById(R.id.course);
        courseAutoVP = (AutoPlayingViewPager) view.findViewById(R.id.course_viewpager);
        searchBtn = (ImageButton) view.findViewById(R.id.course_search_ib);

        imagesCourse = new int[] {R.drawable.viewpage_1,R.drawable.viewpage_2,R.drawable.viewpage_3,R.drawable.viewpage_4};
        imageTitle = new String[] {"1","2","3","4"};

        CourseAdapter courseAdapter = new CourseAdapter(getContext());
        course_list.setAdapter(courseAdapter);

        course_list.setOnItemClickListener(this);
        searchBtn.setOnClickListener(this);

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

        return view;
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
        Intent intent = new Intent(getContext(), CourseInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("course_selected",String.valueOf(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.course_search_ib:
                startActivity(new Intent(getContext(), SearchActivity.class));
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

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            //模拟网络请求获取数据
            try {
                Thread.sleep(2000);//模拟休眠2秒
                mAutoPlayInfoList = changeAutoPlayInfoList();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //数据加载后更新UI
            courseAutoVP.initialize(mAutoPlayInfoList).build();
            //mAutoPlayingViewPager.setOnPageItemClickListener(onPageItemClickListener);
            courseAutoVP.startPlaying();
        }
    }

    /**
     * 将数据转换为AutoPlayInfo形式
     */
    private List<AutoPlayInfo> changeAutoPlayInfoList(){
        List<AutoPlayInfo> autoPlayInfoList = new ArrayList<AutoPlayInfo>();
        for(int i = 0 ; i < imagesCourse.length ; i ++){
            AutoPlayInfo autoPlayInfo = new AutoPlayInfo();
            autoPlayInfo.setImageId(imagesCourse[i]);
            //autoPlayInfo.setAdLinks("");//无数据时不跳转
            autoPlayInfo.setTitle(imageTitle[i]);
            autoPlayInfoList.add(autoPlayInfo);
        }
        return autoPlayInfoList;
    }

    @Override
    public void onResume() {
        //没有数据时不执行startPlaying,避免执行几次导致轮播混乱
        if(mAutoPlayInfoList != null && !mAutoPlayInfoList.isEmpty()){
            courseAutoVP.startPlaying();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        courseAutoVP.stopPlaying();
        super.onPause();
    }
}
