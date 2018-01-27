package com.example.asus.herb4health;

/**
 * Created by Non on 9/2/2017.
 */

public class QuestionBank {
    // array of questions
    private String textQuestions [] = {
            "1. สมุนไพรชนิดใด เป็นสมุนไพรลดไขมันในเส้นเลือด?",
            "2. สมุนไพรชนิดใด เป็นสมุนไพรช่วยบำรุงหัวใจ?",
            "3. ฟักทองมีสรรพคุณทางยา ใช้ทำอะไร?",
            "4. ถ้าเเพื่อนคุณล้มจนเกิดแผลถลอก คุณจะใช้สมุนไพรชนิดไหนทาแผลเพื่อน?",
            "5. ใบชาและดาวเรืองมีสรรพคุณ ใช้ทำอะไร?",
            "6. ถ้ามีอาการไอ จะเลือกใช้สมุนไพรชนิดไหน เพื่อลดอาการ?",
            "7. สับปะรดมีสรรพคุณช่วยรักษาอาการข้อใด?",
            "8. ขิงช่วยรักษาอาการใด?",
            "9. หัวปลีเป็นส่วนประกอบใดของกล้วย?",
            "10. พืชชนิดใดใช้รักษากลากเกลื้อน?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"ทุเรียน", "ส้ม", "ถั่วเหลือง", "อินตาผาลัม"},
            {"แปะก๊วย", "กระท้อน", "ว่านหางจระเข้", "ขมิ้นชัน"},
            {"รักษาแผลสด", "รักษาไข้หวัด", "รักษาอาการปวดเมื้อย", "ขับถ่ายพยาธิ"},
            {"แปะก๊วย", "ว่านหางจระเข้", "บัวบก", "ไม่มีคำตอบที่ถูกต้อง"},
            {"ลดความร้อน", "รักษาลำไส้อักเสบ", "รักษาหัวใจล้มเหลว", "ไม่มีคำตอบที่ถูกต้อง"},
            {"แปะก๊ํวย", "ยาแก้ไอ", "บัวบก", "มะนาว"},
            {"อาการเจ็บป่วยในระบบทางเดินปัสสาวะที่มีอาการขัดเบา", "อาการปวดฟัน", "โรคผิวหนังพุพอง", "รักษาแผลไฟไหม้ น้ำร้อนลวก"},
            {"คลื่นไส้อาเจียน", "ท้องผูก", "กลากเกลื้อน", "ไม่มีคำตอบที่ถูกต้อง"},
            {"ผล", "ดอก", "ใบ", "เมล็ด"},
            {"มะละกอ", "ว่านหางจระเข้", "บัวบก", "กระเพรา"}
    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {"ถั่วเหลือง", "แปะก๊วย", "ขับถ่ายพยาธิ", "ว่านหางจระเข้","ลดความร้อน","มะนาว"
    ,"อาการเจ็บป่วยในระบบทางเดินปัสสาวะที่มีอาการขัดเบา","คลื่นไส้อาเจียน","ดอก","กระเพรา"};


    // method returns number of questions
    public int getLength(){
        return textQuestions.length;
    }

    // method returns question from array textQuestions[] based on array index
    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    // method return a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    //  method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
