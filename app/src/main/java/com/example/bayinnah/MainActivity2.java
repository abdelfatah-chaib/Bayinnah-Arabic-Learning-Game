package com.example.bayinnah;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

public class MainActivity2 extends AppCompatActivity {

    ImageView img;
    private Context context;
    private QuizDatabaseHelper quizDbHelper;
    private TextView questionText;
    private AppCompatButton option1Button;
    private AppCompatButton option2Button;
    private AppCompatButton option3Button;
    private AppCompatButton option4Button;

    private SQLiteDatabase db;
    private Cursor quizCursor;
    private int questionNumber = 0;
    private int score = 0;
    private int totalQuestions = 5;
    private boolean allQuestionsAnswered = false;
    private Button playButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        QuizDatabaseHelper dbHelper = new QuizDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();


        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024); //the 100MB is the new size
        } catch (Exception e) {
            e.printStackTrace();
        }

      /*  Parleur parleur = new Parleur(WordsActivity.this);
        String mot = String.valueOf(mot_txt.getText());
        parleur.parler(mot);
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String mot = String.valueOf(mot_txt.getText());
                parleur.parler(mot);
            }
        });*/

      /*  img = findViewById(R.id.imageView2);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp= MediaPlayer.create(MainActivity.this,R.raw.bell);
                mp.start();
                return false;
            }
        });*/

                                    //87---->230
        // Insert a question with an image
     /* byte[] imageData = getImageData();
        insertQuizQuestion(db, "Quel est ce nombre?", "ثَمَانِيَةٌ", "سَبْعَةٌ", "ثَلاَثَةٌ", "صِفْرٌ",2, "nombres", 1, imageData);
        byte[] imageData2 = getImageData2();
        insertQuizQuestion2(db, "Quel est ce nombre?", "عَشَرَةٌ", "تِسْعَةٌ", "خَمْسَةٌ", "صِفْرٌ",3, "nombres", 1, imageData2);
        byte[] imageData3 = getImageData3();
        insertQuizQuestion3(db, "Quel est ce nombre?", "وَاحدٌ", "صِفْرٌ", "اثْنَان", "خَمْسَةٌ",1, "nombres", 1, imageData3);
        byte[] imageData4 = getImageData4();
        insertQuizQuestion4(db, "Quel est ce nombre?", "أَرْبَعَةٌ", "صِفْرٌ", "اثْنَان", "ثَمَانِيَةٌ",3, "nombres", 1, imageData4);
        byte[] imageData5 = getImageData5();
        insertQuizQuestion5(db, "Quel est ce nombre?", "ثَلاَثَةٌ", "عَشَرَةٌ", "اثْنَان", "تسْعَةٌ",1, "nombres", 1, imageData5);
        byte[] imageData6 = getImageData6();
        insertQuizQuestion6(db, "Quel est cet nombre?", "ثَلاَثَةٌ", "أَرْبَعَةٌ", "اثْنَان", "ستَّةٌ",4, "nombres", 1, imageData6);
        byte[] imageData7 = getImageData7();
        insertQuizQuestion7(db, "Quel est ce nombre?", "وَاحدٌ", "ثَمَانِيَةٌ", "اثْنَان", "تسْعَةٌ",2, "nombres", 1, imageData7);
        byte[] imageData8 = getImageData8();
        insertQuizQuestion8(db, "Quel est ce nombre?", "سَبْعَةٌ", "ثَمَانِيَةٌ", "أَرْبَعَةٌ", "ثَلاَثَةٌ",3, "nombres", 1, imageData8);
        byte[] imageData9 = getImageData9();
        insertQuizQuestion9(db, "Quel est ce nombre?", "صِفْرٌ", "ثَمَانِيَةٌ", "خَمْسَةٌ", "تسْعَةٌ",4, "nombres", 1, imageData9);
        byte[] imageData10 = getImageData10();
        insertQuizQuestion10(db, "Quel est ce nombre?", "عَشَرَةٌ", "ثَمَانِيَةٌ", "سَبْعَةٌ", "ستَّةٌ",1, "nombres", 1, imageData10);
        byte[] imageData11 = getImageData11();
        insertQuizQuestion11(db, "Quelle cette couleur?", "أَحْمَرٌٌ", "بَنَفْسَجي", "أَخْضَرٌ", "أصْفَرٌ",2, "couleur", 2, imageData11);
        byte[] imageData12 = getImageData12();
        insertQuizQuestion12(db, "Quelle cette couleur?", "وَرْديٌّ", "أَحْمَرٌٌ", "رَمَادي", "أَسْوَدٌ",3, "couleur", 2, imageData12);
        byte[] imageData13 = getImageData13();
        insertQuizQuestion13(db, "Quelle cette couleur?", "أَخْضَرٌ", "أَزْرَقٌ", "أَبْيَضٌ", "أَسْوَدٌ",1, "couleur", 2, imageData13);
        byte[] imageData14 = getImageData14();
        insertQuizQuestion14(db, "Quelle cette couleur?", "أَسْوَدٌ", "رَمَادي", "أَبْيَضٌ", "وَرْدي",3, "couleur", 2, imageData14);
        byte[] imageData15 = getImageData15();
        insertQuizQuestion15(db, "Quelle cette couleur?", "أَزْرَقٌ", "بُرْتُقَالي", "بَنَفْسَجي", "وَرْدي",1, "couleur", 2, imageData15);
        byte[] imageData16 = getImageData16();
        insertQuizQuestion16(db, "Quelle cette couleur?", "أَزْرَقٌ", "بَنَفْسَجي", "أَحْمَرٌٌ", "أَسْوَدٌ",4, "couleur", 2, imageData16);
        byte[] imageData17 = getImageData17();
        insertQuizQuestion17(db, "Quelle cette couleur?", "أَحْمَرٌٌ", "أصْفَرٌ", "أَسْوَدٌ", "أَبْيَضٌ",2, "couleur", 2, imageData17);
        byte[] imageData18 = getImageData18();
        insertQuizQuestion18(db, "Quelle cette couleur?", "أَخْضَرٌ", "بَنَفْسَجي", "أَحْمَرٌٌ", "بُرْتُقَالي",3, "couleur", 2, imageData18);
        byte[] imageData19 = getImageData19();
        insertQuizQuestion19(db, "Quelle cette couleur?", "أصْفَرٌ", "أَزْرَقٌ", "أَبْيَضٌ", "وَرْدي",4, "couleur", 2, imageData19);
        byte[] imageData20 = getImageData20();
        insertQuizQuestion20(db, "Quelle cette couleur?", "بُرْتُقَالي", "بَنَفْسَجي", "وَرْدي", "أصْفَرٌ",1, "couleur", 2, imageData20);

        byte[] imageData21 = getImageData21();
        insertQuizQuestion21(db, "Comment écrire ceci?", "معْطَفٌ", "قُبَّعَةٌ", "قُفَّازٌ", "فُسْتَانٌ",2, "Clothing", 7, imageData21);
        byte[] imageData22 = getImageData22();
        insertQuizQuestion22(db, "Comment écrire ceci?", "سرْوَالٌ", "حذَاءٌ", "معْطَفٌ", "وِشَاحٌ",3, "Clothing", 7, imageData22);
        byte[] imageData23 = getImageData23();
        insertQuizQuestion23(db, "Comment écrire ceci?", "فُسْتَانٌ", "قُبَّعَةٌ", "قُفَّازٌ", "حذَاءٌ",1, "Clothing", 7, imageData23);
        byte[] imageData24 = getImageData24();
        insertQuizQuestion24(db, "Comment écrire ceci?", "سرْوَالٌ", "حذَاءٌ", "قُفَّازٌ", "معْطَفٌ",3, "Clothing", 7, imageData24);
        byte[] imageData25 = getImageData25();
        insertQuizQuestion25(db, "Comment écrire ceci?", "سُتْرَةٌ", "سرْوَالٌ", "فُسْتَانٌ", "قُفَّازٌ",1, "Clothing", 7, imageData25);
        byte[] imageData26 = getImageData26();
        insertQuizQuestion26(db, "Comment écrire ceci?", "سُتْرَةٌ", "قُبَّعَةٌ", "حذَاءٌ", "سرْوَالٌ",4, "Clothing", 7, imageData26);
        byte[] imageData27 = getImageData27();
        insertQuizQuestion27(db, "Comment écrire ceci?", "فُسْتَانٌ", "حذَاءٌ", "سُتْرَةٌ", "قُبَّعَةٌ",2, "Clothing", 7, imageData27);
        byte[] imageData28 = getImageData28();
        insertQuizQuestion28(db, "Comment écrire ceci?", "فُسْتَانٌ", "معْطَفٌ", "قَمِيصٌ", "سُتْرَةٌ",3, "Clothing", 7, imageData28);
        byte[] imageData29 = getImageData29();
        insertQuizQuestion29(db, "Comment écrire ceci?", "قُبَّعَةٌ", "قُفَّازٌ", "حذَاءٌ", "قَمِيصٌ",4, "Clothing", 7, imageData29);
        byte[] imageData30 = getImageData30();
        insertQuizQuestion30(db, "Comment écrire ceci?", "سُتْرَةٌ", "حذَاءٌ", "معْطَفٌ", "وِشَاحٌ",4, "Clothing", 7, imageData30);
        byte[] imageData31 = getImageData31();
        insertQuizQuestion31(db, "Comment écrire ceci?", "شَجَرَةٌ", "وَرْدَةٌ", "حِجَارَةٌ", "بَحْرٌ",2, "nature", 4, imageData31);
        byte[] imageData32 = getImageData32();
        insertQuizQuestion32(db, "Comment écrire ceci?", "جِبَالٌ", "نَهْرٌ", "قَمَرٌ", "شَمْسٌ",3, "nature", 4, imageData32);
        byte[] imageData33 = getImageData33();
        insertQuizQuestion33(db, "Comment écrire ceci?", "جِبَالٌ", "شَجَرَةٌ", "وَرْدَةٌ", "شَمْسٌ",1, "nature", 4, imageData33);
        byte[] imageData34 = getImageData34();
        insertQuizQuestion34(db, "Comment écrire ceci?", "وَرْدَةٌ", "نَهْرٌ", "غَيْمَةٌ", "شَجَرَةٌ",3, "nature", 4, imageData34);
        byte[] imageData35 = getImageData35();
        insertQuizQuestion35(db, "Comment écrire ceci?", "قَوْسُ قُزَحْ", "بَحْرٌ", "غَيْمَةٌ", "وَرْدَةٌ",1, "nature", 4, imageData35);
        byte[] imageData36 = getImageData36();
        insertQuizQuestion36(db, "Comment écrire ceci?", "قَوْسُ قُزَحْ", "قَمَرٌ", "شَمْسٌ", "نَهْرٌ",4, "nature", 4, imageData36);
        byte[] imageData37 = getImageData37();
        insertQuizQuestion37(db, "Comment écrire ceci?", "شَجَرَةٌ", "بَحْرٌ", "شَمْسٌ", "قَمَرٌ",2, "nature", 4, imageData37);
        byte[] imageData38 = getImageData38();
        insertQuizQuestion38(db, "Comment écrire ceci?", "وَرْدَةٌ", "غَيْمَةٌ", "نَجْمَةٌ", "بَحْرٌ",3, "nature", 4, imageData38);
        byte[] imageData39 = getImageData39();
        insertQuizQuestion39(db, "Comment écrire ceci?", "نَهْرٌ", "شَجَرَةٌ", "قَمَرٌ", "شَمْسٌ",4, "nature", 4, imageData39);
        byte[] imageData40 = getImageData40();
        insertQuizQuestion40(db, "Comment écrire ceci?", "غَيْمَةٌ", "نَهْرٌ", "وَرْدَةٌ", "شَجَرَةٌ",4, "nature", 4, imageData40);

        byte[] imageData41 = getImageData41();
        insertQuizQuestion41(db, "Qui est sur la photo ?", "أَخٌ", "أَبٌ", "جَدٌّ", "أُخْتٌ",2, "family", 3, imageData41);
        byte[] imageData42 = getImageData42();
        insertQuizQuestion42(db, "Qui est sur la photo ?", "جَدَّةٌ", "عَمٌّ", "أُمٌّ", "وَلَدٌ",3, "family", 3, imageData42);
        byte[] imageData43 = getImageData43();
        insertQuizQuestion43(db, "Qui est sur la photo ?", "جَدٌّ", "أُخْتٌ", "فَتَأةٌ", "أُمٌّ",1, "family", 3, imageData43);
        byte[] imageData44 = getImageData44();
        insertQuizQuestion44(db, "Qui est sur la photo ?", "أَخٌ", "وَلَدٌ", "جَدَّةٌ", "أَبٌ",3, "family", 3, imageData44);
        byte[] imageData45 = getImageData45();
        insertQuizQuestion45(db, "Qui est sur la photo ?", "وَلَدٌ", "فَتَاةٌ", "عَمَّةٌ", "جَدٌّ",1, "family", 3, imageData45);
        byte[] imageData46 = getImageData46();
        insertQuizQuestion46(db, "Qui est sur la photo ?", "عَمٌّ", "أُمٌّ", "جَدَّةٌ", "فَتَاةٌ",4, "family", 3, imageData46);
        byte[] imageData47 = getImageData47();
        insertQuizQuestion47(db, "Qui est sur la photo ?", "عَمَّةٌ", "أَخٌ", "أَبٌ", "جَدٌّ",2, "family", 3, imageData47);
        byte[] imageData48 = getImageData48();
        insertQuizQuestion48(db, "Qui est sur la photo ?", "أُمٌّ", "عَمَّةٌ", "أُخْتٌ", "عَمٌّ",3, "family", 3, imageData48);
        byte[] imageData49 = getImageData49();
        insertQuizQuestion49(db, "Qui est sur la photo ?", "وَلَدٌ", "فَتَاةٌ", "جَدٌّ", "عَمٌّ",4, "family", 3, imageData49);
        byte[] imageData50 = getImageData50();
        insertQuizQuestion50(db, "Qui est sur la photo ?", "أَبٌ", "أُمٌّ", "جَدَّةٌ", "عَمَّةٌ",4, "family", 3, imageData50);

        byte[] imageData51 = getImageData51();
        insertQuizQuestion51(db, "Comment écrire ceci?", "لَحْمٌ", "مَوْزٌ", "خُوخٌ", "بَقْدُونِسٌ",2, "nourriture", 5, imageData51);
        byte[] imageData52 = getImageData52();
        insertQuizQuestion52(db, "Comment écrire ceci?", "جَزَرٌ", "حَلْوَى", "تُفَّاحَةٌ", "خُوخٌ",3, "nourriture", 5, imageData52);
        byte[] imageData53 = getImageData53();
        insertQuizQuestion53(db, "Comment écrire ceci?", "لَحْمٌ", "جَزَرٌ", "اَفُوكَا", "جُبْنٌ",1, "nourriture", 5, imageData53);
        byte[] imageData54 = getImageData54();
        insertQuizQuestion54(db, "Comment écrire ceci?", "جُبْنٌ", "خُوخٌ", "جَزَرٌ", "بَطِّيخٌ",3, "nourriture", 5, imageData54);
        byte[] imageData55 = getImageData55();
        insertQuizQuestion55(db, "Comment écrire ceci?", " اَفُوكَا", "حَلْوَى", "جَزَرٌ", "لَحْمٌ",1, "nourriture", 5, imageData55);
        byte[] imageData56 = getImageData56();
        insertQuizQuestion56(db, "Comment écrire ceci?", "حَلْوَى", "بَطِّيخٌ", "بَقْدُونِسٌ", "جُبْنٌ",4, "nourriture", 5, imageData56);
        byte[] imageData57 = getImageData57();
        insertQuizQuestion57(db, "Comment écrire ceci?", "حَلْوَى", "خُوخٌ", "جَزَرٌ", "لَحْمٌ",2, "nourriture", 5, imageData57);
        byte[] imageData58 = getImageData58();
        insertQuizQuestion58(db, "Comment écrire ceci?", "جُبْنٌ", "بَطِّيخٌ", "بَقْدُونِسٌ", "اَفُوكَا",3, "nourriture", 5, imageData58);
        byte[] imageData59 = getImageData59();
        insertQuizQuestion59(db, "Comment écrire ceci?", "بَقْدُونِسٌ", "تُفَّاحَةٌ", "مَوْزٌ", "حَلْوَى",4, "nourriture", 5, imageData59);
        byte[] imageData60 = getImageData60();
        insertQuizQuestion60(db, "Comment écrire ceci?", "تُفَّاحَةٌ", "جُبْنٌ", "مَوْزٌ", "بَطِّيخٌ",4, "nourriture", 5, imageData60);

        byte[] imageData61 = getImageData61();
        insertQuizQuestion61(db, "Quel est cet animal?", "بِطْرِيقٌ", "قِطٌّ", "تِنِّينٌ", "أَسَذٌ",2, "animals", 6, imageData61);
        byte[] imageData62 = getImageData62();
        insertQuizQuestion62(db, "Quel est cet animal?", "تِمْسَاحٌ", "تِنِّينٌ", "كَلْبٌ", "بَطَّةٌ",3, "animals", 6, imageData62);
        byte[] imageData63 = getImageData63();
        insertQuizQuestion63(db, "Quel est cet animal?", "بِطْرِيقٌ", "تِنِّينٌ", "أَرْنَبٌ", "أَسَذٌ",1, "animals", 6, imageData63);
        byte[] imageData64 = getImageData64();
        insertQuizQuestion64(db, "Quel est cet animal?", "قِطٌّ", "كَلْبٌ", "تِمْسَاحٌ", "ثُعْبَانٌ",3, "animals", 6, imageData64);
        byte[] imageData65 = getImageData65();
        insertQuizQuestion65(db, "Quel est cet animal?", " أَسَذٌ", "أَرْنَبٌ", "بَطَّةٌ", "ثُعْبَانٌ",1, "animals", 6, imageData65);
        byte[] imageData66 = getImageData66();
        insertQuizQuestion66(db, "Quel est cet animal?", "تِمْسَاحٌ", "بِطْرِيقٌ", "قِطٌّ", "تِنِّينٌ",4, "animals", 6, imageData66);
        byte[] imageData67 = getImageData67();
        insertQuizQuestion67(db, "Quel est cet animal?", "ثَعْلَبٌ", "ثُعْبَانٌ", "أَرْنَبٌ", "تِمْسَاحٌ",2, "animals", 6, imageData67);
        byte[] imageData68 = getImageData68();
        insertQuizQuestion68(db, "Quel est cet animal?", "أَسَذٌ", "كَلْبٌ", "ثَعْلَبٌ", "بَطَّةٌ",3, "animals", 6, imageData68);
        byte[] imageData69 = getImageData69();
        insertQuizQuestion69(db, "Quel est cet animal?", "ثُعْبَانٌ", "قِطٌّ", "ثَعْلَبٌ", "بَطَّةٌ",4, "animals", 6, imageData69);
        byte[] imageData70 = getImageData70();
        insertQuizQuestion70(db, "Quel est cet animal?", "قِطٌّ", "بِطْرِيقٌ", "تِنِّينٌ", "أَرْنَبٌ",4, "animals", 6, imageData70);*/

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        stage fragment = new stage();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
    @Override
    protected void onDestroy() {
        if (quizCursor != null) {
            quizCursor.close();
        }
        db.close();
        super.onDestroy();
    }
                                    ///247->1789
 /*private void insertQuizQuestion(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion2(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData2() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 100x100 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 80
        return stream.toByteArray();
    }

    private void insertQuizQuestion3(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData3() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.numbreone);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 100x100 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 80
        return stream.toByteArray();
    }


    private void insertQuizQuestion4(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData4() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion5(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData5() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.trois);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }

    private void insertQuizQuestion6(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData6() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }



    private void insertQuizQuestion7(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData7() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.height);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion8(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData8() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion9(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData9() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion10(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData10() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion11(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData11() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.purpule);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion12(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData12() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gray);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }



    private void insertQuizQuestion13(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData13() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion14(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData14() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }



    private void insertQuizQuestion15(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData15() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blue);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }



    private void insertQuizQuestion16(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData16() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.black);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion17(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData17() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yellow);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion18(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData18() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion19(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData19() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pink);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }

    private void insertQuizQuestion20(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData20() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.orange);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }

    private void insertQuizQuestion21(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData21() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cap);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion22(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData22() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.coat);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion23(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }
    private byte[] getImageData23() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dress);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion24(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData24() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gloves);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion25(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData25() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jacket);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion26(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData26() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pants);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }

    private void insertQuizQuestion27(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData27() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shoes);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion28(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData28() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sweater);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion29(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData29() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tshirt);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }

    private void insertQuizQuestion30(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }
    private byte[] getImageData30() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.scarf);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion31(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData31() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.flower);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion32(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData32() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moon);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion33(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData33() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mountains);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion34(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData34() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloud);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion35(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData35() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rainbow);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion36(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData36() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.river);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion37(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData37() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sea);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion38(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData38() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion39(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData39() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sun);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion40(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData40() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tree);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion41(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData41() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.father);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion42(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData42() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mom);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion43(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData43() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.grandpa);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion44(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData44() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.grandma);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion45(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData45() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.boy);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion46(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData46() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.girl);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion47(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData47() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.brother);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion48(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData48() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sister);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion49(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData49() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.uncle);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion50(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData50() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tente);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion51(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData51() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.banana);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion52(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData52() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pomme);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion53(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData53() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lahm);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion54(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData54() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.carrot);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion55(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData55() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avocat);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion56(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData56() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.frommage);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion57(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData57() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.khokh);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion58(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData58() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baqdonos);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion59(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData59() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.halwa);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion60(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData60() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dlah);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }
    private void insertQuizQuestion61(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData61() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion62(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData62() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 100x100 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 80
        return stream.toByteArray();
    }

    private void insertQuizQuestion63(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData63() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitriq);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 100x100 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 80
        return stream.toByteArray();
    }


    private void insertQuizQuestion64(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData64() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.timsah);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion65(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData65() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lion);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }

    private void insertQuizQuestion66(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData66() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tinin);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }



    private void insertQuizQuestion67(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData67() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.snake);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion68(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData68() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ta3lab);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion69(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData69() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bata);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }


    private void insertQuizQuestion70(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);
        db.insert("quiz_questions", null, quizQuestionValues);
    }

    private byte[] getImageData70() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.arnabb);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false); // resize image to 400x400 pixels
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); // compress as JPEG with quality level of 90
        return stream.toByteArray();
    }*/

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/
}
