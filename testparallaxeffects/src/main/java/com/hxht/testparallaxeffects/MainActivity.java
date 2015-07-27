package com.hxht.testparallaxeffects;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hxht.testparallaxeffects.customview.MyListView;


public class MainActivity extends Activity {

    private static final String[] names = new String[]{
            "宋江",
            "卢俊义",
            "吴用",
            "公孙胜",
            "关胜",
            "林冲",
            "秦明",
            "呼延灼",
            "花荣",
            "柴进",
            "李应",
            "朱仝",
            "鲁智深",
            "武松",
            "董平",
            "张清",
            "杨志",
            "徐宁",
            "索超",
            "戴宗",
            "刘唐",
            "李逵",
            "史进",
            "穆弘",
            "雷横",
            "李俊",
            "阮小二",
            "张横",
            "阮小五",
            "张顺",
            "阮小七",
            "杨雄",
            "石秀",
            "解珍",
            "解宝 ",
            "燕青",
            "朱武",
            "黄信",
            "孙立",
            "宣赞",
            "郝思文",
            "韩滔",
            "彭玘",
            "单廷圭",
            "魏定国",
            "萧让",
            "裴宣",
            "欧鹏",
            "邓飞",
            "燕顺",
            "杨林",
            "凌振",
            "蒋敬",
            "吕方",
            "郭盛",
            "安道全",
            "皇甫端",
            "王英",
            "扈三娘",
            "鲍旭",
            "樊瑞",
            "孔明",
            "孔亮",
            "项充",
            "李衮",
            "金大坚",
            "马麟",
            "童威",
            "童猛",
            "孟康",
            "侯健",
            "陈达",
            "杨春",
            "郑天寿",
            "陶宗旺",
            "宋清",
            "乐和",
            "龚旺",
            "丁得孙",
            "穆春",
            "曹正",
            "宋万",
            "杜迁",
            "薛永",
            "李忠",
            "周通",
            "汤隆",
            "杜兴",
            "邹渊",
            "邹润",
            "朱贵",
            "朱富",
            "施恩",
            "蔡福",
            "蔡庆",
            "李立",
            "李云",
            "焦挺",
            "石勇",
            "孙新",
            "顾大嫂",
            "孙二娘",
            "王定六",
            "郁保四",
            "白胜",
            "时迁",
            "段景住"
    };
    private MyListView lv;
    private ImageView headerView;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initData();
    }

    private void initData() {
        lv.addHeaderView(view);
        lv.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, names) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.BLACK);
                return tv;
            }
        });
        lv.setOverScrollMode(ListView.OVER_SCROLL_NEVER);

        headerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                lv.setParallaxImageView(headerView);
                //headerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                headerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void initViews() {
        view = View.inflate(MainActivity.this, R.layout.activity_lv_header, null);
        headerView = (ImageView) view.findViewById(R.id.iv);
        lv = (MyListView) findViewById(R.id.lv);
    }
}
