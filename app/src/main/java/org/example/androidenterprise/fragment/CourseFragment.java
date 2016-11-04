package org.example.androidenterprise.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.CourseCalendarActivity;
import org.example.androidenterprise.activity.CourseInfoActivity;
import org.example.androidenterprise.activity.SearchActivity;
import org.example.androidenterprise.adapter.CourseAdapter;
import org.example.androidenterprise.model.CourseEntity;
import org.example.androidenterprise.model.ListRequestEntity;
import org.example.androidenterprise.model.ViewPagerEntity;
import org.example.androidenterprise.utils.AutoPlayInfo;
import org.example.androidenterprise.view.AutoPlayingViewPager;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static org.example.androidenterprise.utils.Constant.*;

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
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";


    @ViewInject(R.id.course_viewpager)
    AutoPlayingViewPager courseAutoVP;
    @ViewInject(R.id.lv_course)
    ListView course_list;
    @ViewInject(R.id.topbar_course)
    TopbarView topbar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<AutoPlayInfo> mAutoPlayInfoList;
    private ViewPagerEntity responseVp;
    private CourseEntity responseCourse;
//    public static CourseEntity course;


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
        setTopbar();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));

        RequestParams paramsVp = new RequestParams(VIEWPAGER_URL);
        paramsVp.setAsJsonContent(true);
        paramsVp.setBodyContent("{\"code\":2004,\"id\":9527}");
        x.http().post(paramsVp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("2333333", "2333333");
                responseVp = new Gson().fromJson(result, new TypeToken<ViewPagerEntity>() {
                }.getType());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getContext(), "网络错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

        ListRequestEntity courseRequest = new ListRequestEntity();
        courseRequest.setCode(2051);
        courseRequest.setId(9527);
        courseRequest.setRole("student");
        courseRequest.setMaxtime(0);
        RequestParams paramsCourse = new RequestParams(COURSE_LIST_URL);
        paramsCourse.setAsJsonContent(true);
        paramsCourse.setBodyContent(new Gson().toJson(courseRequest));
//        paramsCourse.setBodyContent("{\"code\":2004,\"id\":9527,\"role\":\"student\",\"maxtime\":0}");
        x.http().post(paramsCourse, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("23333", result);
                responseCourse = new Gson().fromJson(result, new TypeToken<CourseEntity>() {
                }.getType());
                CourseAdapter courseAdapter = new CourseAdapter(getContext(), responseCourse.getList());
                course_list.setAdapter(courseAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        x.view().inject(this, rootView);
        return rootView;
    }

    private void setTopbar() {
        Resources res = getResources();
        topbar.setTopbarTv("课程");
        Drawable ic_table = res.getDrawable(R.mipmap.ic_table);
        topbar.setLeftIb(ic_table);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CourseCalendarActivity.class));
            }
        });
        Drawable ic_search = res.getDrawable(R.mipmap.ic_search);
        topbar.setRight1Ib(ic_search);
        topbar.getRight1Ib().setVisibility(View.VISIBLE);
        topbar.setRight1IbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });
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
                while (responseVp == null) {
                    Thread.sleep(2000);
                }
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
        for (int i = 0; i < responseVp.getTop().size(); i++) {
            AutoPlayInfo autoPlayInfo = new AutoPlayInfo();
            //autoPlayInfo.setImageId(imagesCourse[i]);
            //autoPlayInfo.setAdLinks("");//无数据时不跳转
//            autoPlayInfo.setImageUrl(InitData.course.getAdv().get(i).getImage_url());
//            autoPlayInfo.setAdLinks("");//无数据时不跳转
//            autoPlayInfo.setTitle(InitData.course.getAdv().get(i).getTitle());
            autoPlayInfo.setImageUrl(responseVp.getTop().get(i).getTop_image());
            autoPlayInfo.setAdLinks("");//无数据时不跳转
            autoPlayInfo.setTitle(responseVp.getTop().get(i).getClass_name());
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
