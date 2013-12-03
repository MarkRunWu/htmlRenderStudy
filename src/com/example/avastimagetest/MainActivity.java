
package com.example.avastimagetest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = (ListView) findViewById( R.id.listView );
        listView.setAdapter(new AvastPhotoAdapter(this) );
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    class AvastPhotoAdapter extends BaseAdapter{

        String[] testImageUrls = {
                    "http://gravatar.com/avatar/c5dbb39087c984fdf69013f893c76337/?s=200",
                    "http://gravatar.com/avatar/bf5655c5c7a8156ea35b7c81a0431e83/?s=200",
                    "http://gravatar.com/avatar/89ca4d0eeaeca19a6dde651654318b02/?s=200",
                    "http://gravatar.com/avatar/1bafcc8d9c173ff8d7615bb8e9f1a682/?s=200",
                    "http://gravatar.com/avatar/9384aa941133de9568899241aa891e5c/?s=200",
                    "http://gravatar.com/avatar/9384aa941133de9568899241aa891e5c/?s=200",
                    "http://gravatar.com/avatar/7c7805f7ae8197b86303baf29d5ab050/?s=200",
"http://www.wthefood.com/wp-content/uploads/sites/10/2013/11/DSC00528.jpg"
                    
                    };        
        public AvastPhotoAdapter(Context context ){
            mCtx = context;    
        }
        
        private Context mCtx;
        
        @Override
        public int getCount() {
            return testImageUrls.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return testImageUrls[arg0];
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            if( arg1 == null ){      
                LayoutInflater inflater = (LayoutInflater)mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                arg1 = inflater.inflate(R.layout.list_item, null);                
            }
            ImageView imageView = (ImageView) arg1.findViewById(R.id.imageView);
            new BitmapWorkerTask(mCtx, testImageUrls[arg0], imageView).execute();
            return arg1;
        }
        
    }
}
