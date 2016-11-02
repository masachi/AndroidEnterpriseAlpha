package org.example.androidenterprise.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import org.example.androidenterprise.List.CatagoryList;
import org.example.androidenterprise.List.IntroductionList;
import org.example.androidenterprise.MainActivity;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.InstrumentDetailActivity;
import org.example.androidenterprise.activity.InstrumentInfoActivity;
import org.example.androidenterprise.activity.SearchActivity;
import org.example.androidenterprise.adapter.AlbumAdapter;
import org.example.androidenterprise.adapter.IntroAdapter;
import org.example.androidenterprise.adapter.ItemAdapter;
import org.example.androidenterprise.model.CatagoryEntity;
import org.example.androidenterprise.model.IntroductionEntity;
import org.example.androidenterprise.model.ViewPagerEntity;
import org.example.androidenterprise.utils.AutoPlayInfo;
import org.example.androidenterprise.view.AutoPlayingViewPager;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.example.androidenterprise.view.CustomMeasureListView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static org.example.androidenterprise.utils.UrlAddress.VIEWPAGER_URL;

@ContentView(R.layout.fragment_instrument)

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstrumentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InstrumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstrumentFragment extends BaseFragment implements TabLayout.OnTabSelectedListener, AdapterView.OnItemClickListener, MainActivity.InitTopBar {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @ViewInject(R.id.vp_instrument)
    AutoPlayingViewPager instrumentAutoVP;
    @ViewInject(R.id.tab_instrument)
    TabLayout typeTl;
    @ViewInject(R.id.lv_album)
    CustomMeasureListView albumLv;
    @ViewInject(R.id.lv_instru_info)
    CustomMeasureListView introLv;
    @ViewInject(R.id.gv_instrument)
    CustomMeasureGridView itemGv;
    @ViewInject(R.id.ib_left)
    ImageButton leftIb;
    @ViewInject(R.id.tv_top_bar)
    TextView topTv;
    @ViewInject(R.id.ib_search)
    ImageButton searchIb;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<View> instrumentView;
    private List<View> albumView;
    private List<IntroductionEntity> introLlist;
    private List<CatagoryEntity> cataList;
    private int[] imagesAlbum;
    private List<AutoPlayInfo> mAutoPlayInfoList;

    private ViewPagerEntity response;


    private OnFragmentInteractionListener mListener;

    public InstrumentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InstrumentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstrumentFragment newInstance(String param1, String param2) {
        InstrumentFragment fragment = new InstrumentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));

        // Inflate the layout for this fragment

        introLlist = IntroductionList.getData(getContext());
        cataList = CatagoryList.getData(getContext());

        imagesAlbum = new int[]{R.drawable.viewpage_4, R.drawable.viewpage_3, R.drawable.viewpage_2, R.drawable.viewpage_1};

        instrumentView = new ArrayList<>();
        albumView = new ArrayList<>();

        initTopBar();

        RequestParams params = new RequestParams(VIEWPAGER_URL);
        params.setAsJsonContent(true);
        params.setBodyContent("{\"code\":2004,\"id\":9527}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("2333333", "2333333");
                response = new Gson().fromJson(result, new TypeToken<ViewPagerEntity>() {
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


        for (int image : imagesAlbum) {
            ImageView tempIv = new ImageView(getContext());
            tempIv.setImageResource(image);
            albumView.add(tempIv);
        }

        for (int i = 0; i < cataList.size(); i++) {
            typeTl.addTab(typeTl.newTab().setText(cataList.get(i).getType()), false);
        }

        typeTl.setOnTabSelectedListener(this);
        itemGv.setOnItemClickListener(this);

        AlbumAdapter albumAdapter = new AlbumAdapter(getContext(), imagesAlbum);
        IntroAdapter introAdapter = new IntroAdapter(getContext());
        ItemAdapter itemAdapter = new ItemAdapter(getContext());
        itemGv.setAdapter(itemAdapter);
        albumLv.setAdapter(albumAdapter);
        introLv.setAdapter(introAdapter);
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
    public void onTabSelected(TabLayout.Tab tab) {
        int pos = tab.getPosition();
        Intent intent = new Intent();
        intent.setClass(getContext(), InstrumentInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("tab_selected", String.valueOf(pos));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        int pos = tab.getPosition();
        Intent intent = new Intent();
        intent.setClass(getContext(), InstrumentInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("tab_selected", String.valueOf(pos));
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(), InstrumentDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("instrument_selected", String.valueOf(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    public void initTopBar() {
        leftIb.setVisibility(View.INVISIBLE);
        topTv.setText(R.string.action_bar_music);
    }

//    @Override
//    public void injectView() {
//        leftIb = (ImageButton) topView.findViewById(R.id.ib_left);
//        topTv = (TextView) topView.findViewById(R.id.tv_top_bar);
//        searchIb = (ImageButton) topView.findViewById(R.id.ib_search);
//
//        initTopBar();
//
//        searchIb.setOnClickListener(this);
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        x.view().inject(this, rootView);
        return rootView;
    }

    @Event(value = {R.id.ib_left, R.id.ib_search})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_left:
                break;
            case R.id.ib_search:
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
                while (response == null) {
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
            instrumentAutoVP.initialize(mAutoPlayInfoList).build();
            //mAutoPlayingViewPager.setOnPageItemClickListener(onPageItemClickListener);
            instrumentAutoVP.startPlaying();
        }
    }

    /**
     * 将数据转换为AutoPlayInfo形式
     */
    private List<AutoPlayInfo> changeAutoPlayInfoList() {
        List<AutoPlayInfo> autoPlayInfoList = new ArrayList<AutoPlayInfo>();
        for (int i = 0; i < response.getTop().size(); i++) {
            AutoPlayInfo autoPlayInfo = new AutoPlayInfo();
            autoPlayInfo.setImageUrl(response.getTop().get(i).getTop_image());
            autoPlayInfo.setAdLinks("");//无数据时不跳转
            //autoPlayInfo.setTitle(response.getTop().get(i).getClass_name());
            autoPlayInfoList.add(autoPlayInfo);
        }
        return autoPlayInfoList;
    }

    @Override
    public void onResume() {
        //没有数据时不执行startPlaying,避免执行几次导致轮播混乱
        if (mAutoPlayInfoList != null && !mAutoPlayInfoList.isEmpty()) {
            instrumentAutoVP.startPlaying();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        instrumentAutoVP.stopPlaying();
        super.onPause();
    }

}
