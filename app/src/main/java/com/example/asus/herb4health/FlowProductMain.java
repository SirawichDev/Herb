package com.example.asus.herb4health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.asus.herb4health.AdapterProduct.ProductAdapter;
import com.example.asus.herb4health.Commonflow.CommonProduct;
import com.example.asus.herb4health.Commonflow.Commonflow;
import com.example.asus.herb4health.Model.Product;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class FlowProductMain extends AppCompatActivity {

    FeatureCoverFlow flowProduct;
    ProductAdapter productAdapter;
    TextSwitcher mTitlePd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_product_main);

        //Create data First
        initDataPd();
        productAdapter = new ProductAdapter(CommonProduct.productList,this);
        flowProduct = (FeatureCoverFlow) findViewById(R.id.flowProduct);
        mTitlePd = (TextSwitcher)findViewById(R.id.mtitlePd);
        mTitlePd.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(FlowProductMain.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        flowProduct.setAdapter(productAdapter);
        flowProduct.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitlePd.setText(CommonProduct.productList.get(position).getTitlePd());
            }

            @Override
            public void onScrolling() {

            }
        });
        flowProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FlowProductMain.this,ProductDetail.class);
                intent.putExtra("product_index",i);
                startActivity(intent);
            }
        });
    }
    private void initDataPd(){
        //Example data
        Product product = new Product("ขี้ผึ้งสมุนไพร","1. ไพลหรือว่านไฟ\n" +
                "ส่วนที่ใช้ : เหง้า\n" +
                "สรรพคุณ : ลดอาการปวดเมื่อย เคร็ดขัดยอก ลดอาการผื่นแพ้จากพืช\n" +
                "วิธีทำ : นำเหง้าแห้งบดให้ละเอียด ใช้เป็นส่วนผสม\n" +
                "\n" +
                "2. เสลดพังพอนตัวเมีย\n" +
                "ส่วนที่ใช้ : ใบ\n" +
                "สรรพคุณ : แก้แมลงหรือสัตว์กัดต่อย บรรเทาอาการผื่นแพ้จากพืช\n" +
                "วิธีทำ : นำใบแห้งบดให้ละเอียด ใช้เป็นส่วนผสม\n"
            ,R.drawable.product1);
        CommonProduct.productList.add(product);

        product = new Product("สบู่สมุนไพร","1. เสลดพังพอนตัวเมีย\n" +
                "ส่วนที่ใช้ : เนื้อมะขามเปรี้ยว\n" +
                "สรรพคุณ : ช่วยขจัดเซลล์ผิวที่ตาย ช่วยพลัดเปลี่ยนเซลล์ผิวใหม่ ป้องกันเชื้อแบคทีเรีย\n" +
                "วิธีทำ : นำเฉพาะส่วนเนื้อคั้นน้ำเข้มข้น แยกเอาเฉพาะเนื้อเหลว ใช้เป็นส่วนผสม\n" +
                "\n" +
                "2. ว่านหางจระเข้\n" +
                "ส่วนที่ใช้ : เนื้อจากใบ\n" +
                "สรรพคุณ : ช่วยพลัดเซลล์ผิวใหม่ ป้องกันเชื้อแบคทีเรีย เพิ่มความชุ่มชื้นแก่ผิว\n" +
                "วิธีทำ : นำส่วนเนื้อหรือเมือกจากใบ ใช้เป็นส่วนผสม\n" +
                "\n" +
                "3. ใบบัวบก\n" +
                "ส่วนที่ใช้ : ใบ\n" +
                "สรรพคุณ : ช่วยสมานแผล ลดอาการผื่นคัน ป้องกันเชื้อแบคทีเรีย เพิ่มความชุ่มชื้นแก่ผิว\n" +
                "วิธีทำ : นำใบสดบดคั้นน้ำเข้มข้น และกรองแยกน้ำใช้เป็นส่วนผสม\n",
                R.drawable.product2);
        CommonProduct.productList.add(product);

        product = new Product("ลูกประคบ","1. ขมิ้นชัน\n" +
                "ส่วนที่ใช้ : เหง้า\n" +
                "สรรพคุณ : ให้กลิ่นขมิ้น แก้ผื่นคัน รักษาแผล ต้านเชื้อแบคทีเรีย\n" +
                "วิธีทำ : นำเหง้าขมิ้นชันแห้งสับเป็นชิ้นขนาดเล็กผสมกับสมุนไพรอื่นๆ\n" +
                "2. ว่านไพล\n" +
                "ส่วนที่ใช้ : เหง้า\n" +
                "สรรพคุณ : ให้กลิ่นว่านไพล แก้ผื่นคัน ต้านเชื้อ\n" +
                "แบคทีเรีย ลดอาการขัดหยอก\n" +
                "วิธีทำ : นำเหง้าไพลแห้งสับเป็นชิ้นขนาดเล็กผสมกับสมุนไพรอื่นๆ\n" +
                "3. ตะไคร้\n" +
                "ส่วนที่ใช้ : ลำต้น และใบ\n" +
                "สรรพคุณ : ให้กลิ่นตะไคร้ ต้านเชื้อแบคทีเรีย\n" +
                "วิธีทำ : นำลำต้น และใบสดสับเป็นชิ้นขนาดเล็กผสมกับสมุนไพรอื่นๆ\n" +
                "4. ใบมะกรูด\n" +
                "ส่วนที่ใช้ : ใบ\n" +
                "สรรพคุณ : ให้กลิ่นมะกรูด ต้านเชื้อแบคทีเรีย ลดอาการปวดเมื่อย รักษาแผล\n" +
                "วิธีทำ : นำใบสดหรือใบแห้งสับเป็นชิ้นขนาดเล็กผสมกับสมุนไพรอื่นๆ\n" +
                "5. การบูน\n" +
                "ส่วนที่ใช้ : รากหรือเปลือก\n" +
                "สรรพคุณ : ให้กลิ่นหอมการบูน แก้ปวดเมื่อย รักษาแผล ต้านเชื้อแบคทีเรีย\n" +
                "วิธีทำ : นำส่วนรากหรือเปลือกสับเป็นชิ้นขนาดเล็กผสมกับสมุนไพรอื่นๆ\n"
                ,R.drawable.product3);
        CommonProduct.productList.add(product);

        product = new Product("ธูปสมุนไพร","1. ตะไคร้หอม\n" +
                "ส่วนที่ใช้ : ลำต้น และใบ\n" +
                "สรรพคุณ : ให้กลิ่นหอมตะไคร้ ไล่ยุง และแมลงรบกวน\n" +
                "วิธีทำ : นำส่วนลำต้น และใบที่แห้ง บดให้ละเอียดเป็นผง ใช้เป็นส่วนผสม\n" +
                "2. สะเดา\n" +
                "ส่วนที่ใช้ : ใบ\n" +
                "สรรพคุณ : ไล่ยุง และแมลงรบกวน\n" +
                "วิธีทำ : นำส่วนใบแห้ง บดให้ละเอียดเป็นผง ใช้เป็นส่วนผสม\n" +
                "3. ยูคาลิปตัส\n" +
                "ส่วนที่ใช้ : ใบ\n" +
                "สรรพคุณ : ให้กลิ่นหอมยูคาลิปตัส ไล่ยุง และแมลงรบกวน\n" +
                "วิธีทำ : นำส่วนใบแห้ง บดให้ละเอียดเป็นผง ใช้เป็นส่วนผสม\n"
        ,R.drawable.product4);
        CommonProduct.productList.add(product);

        product = new Product("ยาเม็ดจันทน์ลีลา","ชื่อผลิตภัณฑ์ : ยาเม็ดจันทน์ลีลา \n" +
                "สารสำคัญ : ใน 1 เม็ด ( ผงยา 500 มิลลิกรัม ) ประกอบด้วย โกฐสอ โกฐเขมา โกฐจุฬาลัมพา แก่นจันทน์เทศ แก่นจันทน์แดง ลูกกระดอม บอระเพ็ด รากปลาไหลเผือก หนักสิ่งละ 60.6 มิลลิกรัม หรือ 4 ส่วน พิมเสน หนัก15.2 มิลิกรัม หรือ 1 ส่วน \n" +
                "สรรพคุณ : แก้ไข้ แก้ตัวร้อน \n" +
                "รูปแบบ : ยาเม็ด \n" +
                "วิธีใช้ : ผู้ใหญ่ ครั้งละ 3-4 เม็ด ทุก 4 ชั่วโมง, เด็กอายุ 6-12 ปี ครั้งละ 1-2 เม็ด ทุก 4 ชั่วโมง \n" +
                "ขนาดบรรจุ : 30 เม็ด/ขวด\n" +
                "คำเตือน : ไม่แนะนำให้ใช้ในผู้ที่สงสัยเป็นไข้เลือดออก, หากใช้ยาเป็นเวลานานเกิน 3 วัน แล้วอาการไม่ดีขึ้น ควรปรึกษาแพทย์\n"
        ,R.drawable.product5);
        CommonProduct.productList.add(product);


        product = new Product("สเปรย์กันยุงตะไคร้หอม 60ml.","ชื่อผลิตภัณฑ์ :  สเปรย์กันยุงตะไคร้หอม 60ml.\n" +
                "สารสำคัญ : น้ำมันตะไคร้หอม 6 %\n" +
                "สรรพคุณ : ทาป้องกันยุงกัดได้ประมาณ 3 ชั่วโมง \n" +
                "รูปแบบ : โลชั่น(ชนิดน้ำ) \n" +
                "วิธีใช้ : ทาหรือพ่นบริเวณผิวหนัง\n" +
                "ขนาดบรรจุ : ขวดสเปรย์ 100ml. 60ml. และ 30ml.\n" +
                "คำเตือน : หลีกเลี่ยงบริเวณผิวที่บอบบาง เช่น ใบหน้า ห้ามใช้กับผู้ที่แพ้ง่าย\n"
        ,R.drawable.product6);
        CommonProduct.productList.add(product);


    }


}
