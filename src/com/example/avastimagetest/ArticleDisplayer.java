package com.example.avastimagetest;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

public class ArticleDisplayer extends Activity {
    String htmlSoruce = "<p dir=\"ltr\">每次和朋友相約吃飯，在挑選餐廳時，除了要考慮交通因素，還要考慮店家有沒有那麼多的座位&#8230;等等。這次肚撫我就在同事的推薦下，到「和食 酒 EN」探探，如果不錯，就列入日後聚會的口袋名單吧！</p> <p dir=\"ltr\">根據資料，和食EN 在1992年成立，在日本已經有50多家店，在台灣除了今年新開的板橋大遠百店外，SOGO復興店也有一間。</p> <p dir=\"ltr\">在交通方面，因為就位在板橋大遠百樓上，所以只要搭捷運到板橋站，出站後照著指標，走地下連通道就可以抵達</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-266\" alt=\"DSC00570\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00570.jpg\" width=\"1024\" height=\"683\" /></p> <p dir=\"ltr\">從連通到抵達大遠百後，左轉的電梯可以直接搭到11樓。其他的電梯也可以搭到10樓，再轉搭手扶梯。</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-85\" alt=\"DSC00383\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00383.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 樓下就是威秀影城，大家一起吃飽喝足再下樓看場電影，多麼享受呀！</p> <p dir=\"ltr\">因為整個大遠百11樓都是這間餐廳，所以整間餐廳座位數很多、很深，還有各式的包廂。<br /> <img class=\"alignnone size-full wp-image-250\" alt=\"DSC00554\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00554.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 兩旁都是包廂，真是深深深幾許</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-261\" alt=\"DSC00565\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00565.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 從一開始進門後看到的一般座位</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-257\" alt=\"DSC00561\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00561.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 再進去一點的四人座</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-240\" alt=\"DSC00545\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00545.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 一般包廂</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-254\" alt=\"DSC00558\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00558.jpg\" width=\"683\" height=\"1024\" /><br /> ⇱ 和室包廂，外頭有拉門，所以隱密性很夠，可以好好享用餐點</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-233\" alt=\"DSC00538\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00538.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 而我們是坐在吧台</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-159\" alt=\"DSC00455\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00455.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 因為吧台裡面就是開放式廚房，可以一邊用餐，一邊看廚師們的表演</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-97\" alt=\"DSC00395\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00395.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 這碟子的紋路好有漫畫風格呀XD</p> <p dir=\"ltr\">料理長創作套餐約有10道菜，內容物每天都不一樣，這邊就列出幾道我們很喜歡的菜色</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-91\" alt=\"DSC00389\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00389.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 料理長創新風味前饌 &#8211; 松葉蟹高麗菜拌胡麻醋，吃起來很開胃！</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-96\" alt=\"DSC00394\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00394.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 本日鮮味生魚片，擺盤和新鮮度都吃得到用心</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-231\" alt=\"DSC00532\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00532.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 紅燒饌物或清蒸饌物 &#8211; 燉煮蘿蔔佐湯葉蝦羹。名字取的真好，湯葉指的是底下的豆皮，好吃。</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-172\" alt=\"DSC00468\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00468.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 鮮嫩石板炭燒 &#8211; 石燒沙朗牛排。看著這張圖我肚子又餓了&#8230;（撫肚）。透過石板的加熱，可以自己選擇要多熟，好吃！右邊皺皺的謎樣物體是杏鮑菇，也是很多汁很Juicy！</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-199\" alt=\"DSC00500\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00500.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 季節風味飯 &#8211; 握壽司五貫。自從看了壽司之神的紀錄片後，就愛上看壽司師傅製作握壽司。這次因為是坐吧台，也欣賞了握壽司的製作過程，吃起來也多了一分美味。</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-234\" alt=\"DSC00539\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00539.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 特製和風手工甜點 &#8211; 烤蘋果卡士達醬春捲。吃起來就像在吃頻果派，不過甜度剛好，又香又酥，推薦。</p> <p dir=\"ltr\"><strong>另外推薦幾道<strong>我們單點的</strong>菜</strong></p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-99\" alt=\"DSC00397\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00397.jpg\" width=\"1024\" height=\"683\" /></p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-123\" alt=\"DSC00421\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00421.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 蒜頭醬油鮪魚丼，這道光看圖就可以想像它的美味了，我肚子越來越餓了，喜歡吃魚的人可以點來試試&#8230;推薦！</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-121\" alt=\"DSC00419\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00419.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 岩鹽烤大麥豬排</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-141\" alt=\"DSC00438\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00438.jpg\" width=\"1024\" height=\"683\" /></p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-166\" alt=\"DSC00462\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00462.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 鮭魚豆乳朴葉焗烤&#8230;鮭魚魚肉的鮮美，搭上焗烤的濃郁香氣，一起放進嘴中的滋味，嗚，我要再去吃一次！</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-101\" alt=\"DSC00399\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00399.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 最後是讓我從此愛上玉子燒的 &#8211; 土雞卵玉子燒炙烤，因為用了土雞蛋就是比較香，師傅的調味恰到好處，滿口都是滿滿蛋香，好幸福。</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-212\" alt=\"DSC00514\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00514.jpg\" width=\"1024\" height=\"683\" /><br /> ⇱ 店名就叫和食酒EN，因為這裡也有供酒。有各式冷熱的清酒，還有各種口味的梅酒、沙瓦等等&#8230;，杜甫我點了一杯蜂蜜梅酒（應該不會被說太娘？），和朋友一起享受美好的週末夜晚。</p> <p dir=\"ltr\">前面有提到這間餐廳的空間又大又深，所以不論是什麼用餐目的，想約會、想慶生，或是想要商務用餐都適合。再加上交通很便利，樓下又是百貨公司和電影院，不用擔心用餐完沒地方去，推薦給每一個為了聚餐地點想破頭的人！</p> <p dir=\"ltr\">整餐吃下來也是很飽，帶點微醺，感覺很好</p> <p dir=\"ltr\">喝酒不開車，下面就是板橋捷運站真的很方便！</p> <p dir=\"ltr\">撫肚，精巧又滿足的一餐。</p> <p dir=\"ltr\"><img class=\"alignnone size-full wp-image-228\" alt=\"DSC00528\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00528.jpg\" width=\"1024\" height=\"683\" /> <img class=\"alignnone size-full wp-image-265\" alt=\"DSC00569\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00569.jpg\" width=\"1024\" height=\"683\" /> <img class=\"alignnone size-full wp-image-264\" alt=\"DSC00568\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00568.jpg\" width=\"1024\" height=\"683\" /> <img class=\"alignnone size-full wp-image-263\" alt=\"DSC00567\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00567.jpg\" width=\"1024\" height=\"683\" /> <img class=\"alignnone size-full wp-image-92\" alt=\"DSC00390\" src=\"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00390.jpg\" width=\"1024\" height=\"683\" /></p> <blockquote> <p dir=\"ltr\">官網介紹:</p> <p>「以輕鬆休閒的態度享用我們所提供的傳統和風美食世界的日本料理」，和食EN秉持如此單純的思維為概念由日本東京的商業中心為發跡處，進而進軍臺灣的飲食世界發展，迄今也有六年寒暑且穩定成長中。</p> <p>而為服務更多喜愛日本美食的饕客特地於新北市板橋區展店， 第二家店「碳烤･酒EN」位於 MEGA CITY 大遠百店11樓，希望賓客們以更優閒、更放鬆的心情來享受新形態的「和風美食風格」，感受不同以往的嶄新美食之旅！</p> <ul> <li>時尚摩登外觀顛覆日本料理印象。</li> <li>包廂眾多隱密性高。</li> <li>日本酒種類選擇豐富！</li> </ul> </blockquote> <div id=\"fb_share_1\" style=\";width: 55px;\" name=\"fb_share\"><div id=\"fb-root\"></div><script src=\"http://connect.facebook.net/en_US/all.js#appId=125029517579627&amp;xfbml=1\"></script><fb:like href=\"http://www.wthefood.com/2013/12/02/en-banqiao_1869-1801/\" send=\"false\" layout=\"icon_link\" width=\"55\" show_faces=\"false\" font=\"arial\"></fb:like></div><div class=\"linkwithin_hook\" id=\"http://www.wthefood.com/2013/12/02/en-banqiao_1869-1801/\"></div><div class='shareaholic-canvas' data-app-id='592289' data-app='share_buttons' data-title='聚餐場地不好找？生日、聚餐、約會的好去處－和食 酒 EN板橋店' data-link='http://www.wthefood.com/2013/12/02/en-banqiao_1869-1801/' data-summary=''></div>";
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        new LoadHtml().execute();
    }
    
    public class LoadHtml extends AsyncTask<Void,String,Spanned>{

        @Override
        protected Spanned doInBackground(Void... arg0) {
            Spanned html = Html.fromHtml( htmlSoruce , new Html.ImageGetter() {            
                @Override
                public Drawable getDrawable(String source) {                
                    InputStream is = null;  
                    try {  
                        android.util.Log.v("ids", source);
                        is = (InputStream) new URL(source).getContent();                    
                        Drawable d = Drawable.createFromStream(is, "img");
                        
                        android.util.Log.v("ids", d.getIntrinsicWidth() + " w" );
                        d.setBounds(0, 0, 100,  
                                100);
                        
                        is.close();
                        return d;
                    } catch (Exception e) {  
                        e.printStackTrace();
                        return null;
                    }                
                }}, null);
            return html;                    
        }

        @Override
        protected void onPostExecute(Spanned result) {
            ((TextView)findViewById(R.id.article)).setText(result);
        }
        
        
    }
    
}
