package org.example.androidenterprise.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;

import org.example.androidenterprise.List.CatagoryList;
import org.example.androidenterprise.List.IntroductionList;
import org.example.androidenterprise.Model.CatagoryEntity;
import org.example.androidenterprise.Model.IntroductionEntity;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.InstrumentInfoActivity;
import org.example.androidenterprise.activity.SearchActivity;
import org.example.androidenterprise.adapter.AlbumAdapter;
import org.example.androidenterprise.adapter.IntroAdapter;
import org.example.androidenterprise.adapter.ItemAdapter;
import org.example.androidenterprise.utils.AutoPlayInfo;
import org.example.androidenterprise.utils.AutoPlayingViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstrumentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InstrumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstrumentFragment extends Fragment implements TabLayout.OnTabSelectedListener,View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ListView albumLv;
    private ListView introLv;
    private GridView itemGv;
    private List<IntroductionEntity> introLlist;
    private List<CatagoryEntity> cataList;
    private int[] imagesInstrument;
    private int[] imagesAlbum;
    private String[] imageTitle;
    private List<View> instrumentView;
    private List<View> albumView;
    private TabLayout typeTl;
    private AutoPlayingViewPager instrumentAutoVP;
    private List<AutoPlayInfo> mAutoPlayInfoList;
    private ImageButton searchIb;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instrument,container,false);

        albumLv = (ListView) view.findViewById(R.id.album_lv);
        introLv = (ListView) view.findViewById(R.id.intro_viewpager);
        itemGv = (GridView) view.findViewById(R.id.instrument_gv);
        typeTl = (TabLayout) view.findViewById(R.id.instrument_tab);
        instrumentAutoVP = (AutoPlayingViewPager) view.findViewById(R.id.instrument_viewpager);
        searchIb = (ImageButton) view.findViewById(R.id.instru_search_ib);

        introLlist = IntroductionList.getData(getContext());
        cataList = CatagoryList.getData(getContext());

        imagesInstrument = new int[] {R.drawable.viewpage_1,R.drawable.viewpage_2,R.drawable.viewpage_3,R.drawable.viewpage_4};
        imagesAlbum = new int[] {R.drawable.viewpage_4,R.drawable.viewpage_3,R.drawable.viewpage_2,R.drawable.viewpage_1};
        imageTitle = new String[] {"1","2","3","4"};

        instrumentView = new ArrayList<>();
        albumView = new ArrayList<>();


        for(int image : imagesInstrument){
            ImageView tempIv = new ImageView(getContext());
            tempIv.setImageResource(image);
            instrumentView.add(tempIv);
        }

        for(int image : imagesAlbum){
            ImageView tempIv = new ImageView(getContext());
            tempIv.setImageResource(image);
            albumView.add(tempIv);
        }

        for(int i=0;i<cataList.size();i++) {
            typeTl.addTab(typeTl.newTab().setText(cataList.get(i).getType()), false);
        }

        typeTl.setOnTabSelectedListener(this);
        searchIb.setOnClickListener(this);

        AlbumAdapter albumAdapter = new AlbumAdapter(getContext(),imagesAlbum);
        IntroAdapter introAdapter = new IntroAdapter(getContext());
        ItemAdapter itemAdapter = new ItemAdapter(getContext());
        itemGv.setAdapter(itemAdapter);
        albumLv.setAdapter(albumAdapter);
        introLv.setAdapter(introAdapter);
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
    public void onTabSelected(TabLayout.Tab tab) {
        int pos = tab.getPosition();
        Intent intent = new Intent();
        intent.setClass(getContext(), InstrumentInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("tab_selected",String.valueOf(pos));
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
        bundle.putString("tab_selected",String.valueOf(pos));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.instru_search_ib:
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
                Thread.sleep(1000);//模拟休眠2秒
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
    private List<AutoPlayInfo> changeAutoPlayInfoList(){
        List<AutoPlayInfo> autoPlayInfoList = new ArrayList<AutoPlayInfo>();
        for(int i = 0 ; i < imagesInstrument.length ; i ++){
            AutoPlayInfo autoPlayInfo = new AutoPlayInfo();
            autoPlayInfo.setImageId(imagesInstrument[i]);
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
