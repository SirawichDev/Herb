package com.nsc.apk.herb4health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.nsc.apk.herb4health.Adapterfood.Adapterfood;
import com.nsc.apk.herb4health.Commonflow.Commonflow;
import com.nsc.apk.herb4health.Model.Food;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class CoverFlowMain extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    Adapterfood adapterfood;
    TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_flow_main);

        //Create data First
        initData();
        adapterfood = new Adapterfood(Commonflow.foodList,this);
        coverFlow = (FeatureCoverFlow)findViewById(R.id.coverFlow);
        mTitle = (TextSwitcher)findViewById(R.id.mtitle);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CoverFlowMain.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow.setAdapter(adapterfood);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Commonflow.foodList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CoverFlowMain.this,FoodDetail.class);
                intent.putExtra("food_index",i);
                startActivity(intent);
            }

        });
    }

    private void initData() {
        //Example data
        Food food = new Food("แกงเรียง",
                "แกงเลียง ถือเป็นเมนูที่มีประโยชน์มาก เพราะใส่ผักหลากหลายชนิด ไม่ว่าจะเป็น บวบ ฟักทอง ข้าวโพด ใบแมงลัก อาจจะใส่เห็ดหรือแครอทเพิ่มด้วยก็ได้ เนื้อสัตว์จะเป็นกุ้งหรือหมู ไก่ ก็ได้แล้วแต่คนชอบ แต่ละอย่างนี่สรรพคุณเป็นยาได้หมดเลย แถมยังมีกลิ่นหอม น่ารับประทานซะจริง\n" +
                        "\n" +
                        "ประโยชน์ :\n" +
                        "\n" +
                        "- ใบแมงลัก ช่วยรักษาไข้หวัด หลอดลมอักเสบ ขับลม\n" +
                        "\n" +
                        "- ฟักทอง บำรุงร่างกายและรักษาสายตา\n" +
                        "\n" +
                        "- บวบ บำรุงหัวใจ\n" +
                        "\n" +
                        "- ข้าวโพดอ่อน บำรุงกระเพาะอาหาร"
                ,R.drawable.food_menu);
        Commonflow.foodList.add(food);
         food = new Food("เมี่ยงคำ",
                "เมี่ยงคำ เมนูอาหารว่างสุดโปรดของใครหลายคน สรรพคุณเยอะเกินบรรยาย เพราะเครื่องของเมี่ยงคำก็คือ ผักสมุนไพรหลากหลายชนิด นั่นเอง ราดด้วยน้ำจิ้มหอมหวาน กินร่วมกับคนในครอบครัว ขอบอกเลยว่า มีความสุขสุดๆ ไปเลย\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "ประโยชน์ :\n" +
                        "\n" +
                        "- ขิง เปลือกมะนาว ช่วยบำรุงธาตุไฟ\n" +
                        "\n" +
                        "- มะนาว ใบชะพลู ช่วยบำรุงธาตุน้ำ\n" +
                        "\n" +
                        "- พริก หอมแดง ช่วยบำรุงธาตุลม\n" +
                        "\n" +
                        "- มะพร้าว กุ้งแห้ง น้ำตาล ช่วยบำรุงธาตุดิน\n" +
                        "\n" +
                        "นอกจากบำรุงธาตุแล้วก็ช่วยบำรุงร่างกายของเราหลายอย่าง ไม่ว่าจะเป็น แก้เสมหะ บำรุงกำลัง ขับลม ช่วยเจริญอาหารและขับพยาธิ"
                ,R.drawable.food_menu2);
        Commonflow.foodList.add(food);

        food = new Food("สะเดาน้ำปลาหวาน",
                "สะเดา จัดว่าเป็นอาหารที่อยู่คู่คนไทยมาเนิ่นนานจริงๆ เราเริ่มรับประทานสะเดากันมาตั้งแต่สมัยอยุธยา ภาคกลางมักกินสะเดากับน้ำปลาหวาน เพราะช่วยลดความขมของสะเดา และกินคู่กับปลาดุกย่าง แค่พูดก็หิวซะแล้วล่ะ งั้นมาดูประโยชน์กันดีกว่าว่าดีขนาดไหน ทำไมถึงควรกินสะเดาน้ำปลาหวาน\n" +
                        "\n" +
                        "ประโยชน์ :\n" +
                        "\n" +
                        "- แก้ไข้หัวลม\n" +
                        "\n" +
                        "- แก้ร้อนใน ขับเสมหะ ขับลม\n" +
                        "\n" +
                        "- ช่วยให้ย่อยอาหารดีขึ้น\n" +
                        "\n" +
                        "- ช่วยบำรุงธาตุน้ำและไฟในร่างกายได้ดี"
                ,R.drawable.food_menu3);
        Commonflow.foodList.add(food);

        food = new Food("ไข่เค็มสมุนไพร","" +
                "1. กระเจี๊ยบ\n" +
                "ส่วนที่ใช้ : ผล\n" +
                "สรรพคุณ และประโยชน์ : ลดความดันเลือด เสริมภูมิคุ้มกัน เปลือกไข่ และไข่ขาวด้านนอกมีสีแดงชมพู\n" +
                "วิธีทำ : ต้มน้ำกระเจี๊ยบ ใส่เกลือตามต้องการ นำไข่ดิบมาแช่\n" +
                "2. อัญชัน\n" +
                "ส่วนที่ใช้ : ดอก\n" +
                "สรรพคุณ และประโยชน์ : แก้ร้อนใน บำรุงหัวใจ เปลือก และไข่ขาวด้านนอกมีสีม่วง\n" +
                "วิธีทำ : ต้มน้ำดอกอัญชัน ใส่เกลือตามต้องการ นำไข่ดิบมาแช่\n" +
                "3. ขมิ้นชัน\n" +
                "ส่วนที่ใช้ : เหง้า/หัว\n" +
                "สรรพคุณ และประโยชน์ : ช่วยขับลม รักษาแผลในกระเพาะ เปลือกไข่ และไข่ขาวด้านนอกมีสีเหลือง\n" +
                "วิธีทำ : ต้มน้ำขม้ินชันจากเหง้าดิบหรือเหง้าตากแห้ง หรือผงขมิ้นชัน ใส่เกลือตามต้องการ นำไข่ดิบมาแช่\n" +
                "4. ใบเตย\n" +
                "ส่วนที่ใช้ : ใบ\n" +
                "สรรพคุณ และประโยชน์ :?บำรุงเลือด บำรุงหัวใจ เปลือกไข่ และไข่ขาวด้านนอกมีสีเขียวอ่อน\n" +
                "วิธีทำ : ต้มน้ำใบเตย ใส่เกลือกตามต้องการ นำไข่ดิบมาแช่\n"
                ,R.drawable.food_menu4);
        Commonflow.foodList.add(food);

        food = new Food("ไอศกรีมสมุนไพร","การทำไอศครีมสมุนไพรจะใช้ส่วนเนื้อหรือน้ำสกัดผสมกับเครื่องทำไอศครีมอื่นๆ\n" +
                "1. เผือก\n" +
                "ส่วนที่ใช้ : หัว\n" +
                "สรรพคุณ : เป็นยาระบาย ขับปัสสาวะ และให้พลังงาน\n" +
                "วิธีทำ : นำหัวล้างน้ำให้สะอาด นำมานึ่งหรือต้มให้สุก ปอกเปลือกเอาเฉพาะเนื้อผสม\n" +
                "\n" +
                "2. มะม่วง\n" +
                "ส่วนที่ใช้ : ผล\n" +
                "สรรพคุณ : บำรุงสายตา เพิ่มวิตามินเอ วิตามินซี และให้พลังงาน\n" +
                "วิธีทำ : นำผลปอกเปลือก แยกเอาเฉพาะเนื้อใช้เป็นส่วนผสม\n" +
                "\n" +
                "3. ขนุน\n" +
                "ส่วนที่ใช้ : เนื้อผล\n" +
                "สรรพคุณ : เป็นยาระบาย ให้พลังงาน\n" +
                "วิธีทำ : คัดเอาเฉพาะเนื้อขนุน ฉีกเป็นส่วนๆพอดีคำ ใช้เป็นส่วนผสม\n" +
                "\n" +
                "4. มะพร้าว\n" +
                "ส่วนที่ใช้ : เนื้อมะพร้าว\n" +
                "สรรพคุณ : แก้ท้องเสีย ให้พลังงาน บำรุงร่างกาย\n" +
                "วิธีทำ : ใช้มะพร้าวอ่อน ขุดเอาเฉพาะเนื้อเป็นส่วนผสม\n" +
                "\n" +
                "5. ใบเตย\n" +
                "ส่วนที่ใช้ : ใบ\n" +
                "สรรพคุณ : บำรุงเลือด บำรุงหัวใจ\n" +
                "วิธีทำ : นำใบล้างน้ำให้สะอาด และนำมาต้มเอาเฉพาะน้ำสำหรับเป็นส่วนผสม\n",
            R.drawable.food_menu5);
        Commonflow.foodList.add(food);


        /* food = new Food("เมี่ยงคำ",
                "อร่อย"
                ,R.drawable.ginkgobiloba);
        Commonflow.foodList.add(food); */

    }
}
