package org.example.androidenterprise.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.CourseInfoActivity;
import org.example.androidenterprise.activity.SearchActivity;
import org.example.androidenterprise.adapter.CourseAdapter;
import org.example.androidenterprise.model.CourseEntity;
import org.example.androidenterprise.utils.AutoPlayInfo;
import org.example.androidenterprise.view.AutoPlayingViewPager;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

@ContentView(R.layout.fragment_course)

public class CourseFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @ViewInject(R.id.action_bar_btn_table)
    ImageButton scheduleBtn;
    @ViewInject(R.id.action_bar_btn_clock)
    ImageButton clockBtn;
    @ViewInject(R.id.course_search_ib)
    ImageButton searchBtn;
    @ViewInject(R.id.course_viewpager)
    AutoPlayingViewPager courseAutoVP;
    @ViewInject(R.id.course)
    ListView course_list;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<AutoPlayInfo> mAutoPlayInfoList;
    public static CourseEntity course;


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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        course = new CourseEntity();
        RequestParams params = new RequestParams("http://112.124.38.1:12345/index");
        Log.e("FK","234234123423534534534523");
//        x.http().get(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                Log.e("FK",result);
//                course = new Gson().fromJson(result,new TypeToken<CourseEntity>(){}.getType());
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                Log.e("FK","FK!!!!");
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                Log.e("FK","FK!()()!!!");
//            }
//
//            @Override
//            public void onFinished() {
//                Log.e("FK","2323232323232323");
//            }
//        });

        CourseAdapter courseAdapter = new CourseAdapter(getContext(),course.getCourse_list());
        course_list.setAdapter(courseAdapter);

        course_list.setOnItemClickListener(this);

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

        x.view().inject(this, view);
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
        bundle.putString("course_selected", String.valueOf(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Event(value = {R.id.action_bar_btn_clock, R.id.course_search_ib})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_bar_btn_clock:
                break;
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
    private List<AutoPlayInfo> changeAutoPlayInfoList() {
        List<AutoPlayInfo> autoPlayInfoList = new ArrayList<AutoPlayInfo>();
        for (int i = 0; i < course.getAdv().size(); i++) {
            AutoPlayInfo autoPlayInfo = new AutoPlayInfo();
            //autoPlayInfo.setImageId(imagesCourse[i]);
            //autoPlayInfo.setAdLinks("");//无数据时不跳转
            autoPlayInfo.setImageUrl(course.getAdv().get(i).getImage_url());
            autoPlayInfo.setAdLinks("");//无数据时不跳转
            autoPlayInfo.setTitle(course.getAdv().get(i).getTitle());
            autoPlayInfoList.add(autoPlayInfo);
        }
        return autoPlayInfoList;
    }

    @Override
    public void onResume() {
        //没有数据时不执行startPlaying,避免执行几次导致轮播混乱
        if (mAutoPlayInfoList != null && !mAutoPlayInfoList.isEmpty()) {
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
