/*
 * Copyright (C) 2015 SFApps
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.sfapps.partialmatchsearchinarrayadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        SearchableArrayAdapter<String> adapter = new SearchableArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("Red");
        adapter.add("Blue");
        adapter.add("Yellow");
        adapter.add("Green");
        adapter.add("Pink");
        adapter.add("Orange");
        adapter.add("Purple");
        adapter.add("Gray");
        adapter.add("Black");
        adapter.add("White");
        mListView.setAdapter(adapter);
        ((EditText) findViewById(R.id.editText)).addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        ((SearchableArrayAdapter) mListView.getAdapter()).getFilter().filter(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
