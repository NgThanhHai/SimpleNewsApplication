package com.example.NewsApplication.ViewModels.ReceivingXML;

import android.os.AsyncTask;

import com.example.NewsApplication.Views.ListNewsViews;
import com.example.NewsApplication.ViewModels.ParsingXML.XMLParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class readRSS extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... strings) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(strings[0]);
            InputStreamReader inputReader = new InputStreamReader(url.openConnection().getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputReader);

            String line = "";
            while((line = bufferedReader.readLine()) != null )
            {

                content.append(line);

            }

            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        XMLParser xmlParser = new XMLParser();

        Document document = xmlParser.getDocument(s);

        NodeList nodeList = document.getElementsByTagName("item");

        String title = "";
        String link = "" ;

        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Element element = (Element) nodeList.item(i);
            if (element!=null) {
                title = xmlParser.getValue(element, "title");
                link = xmlParser.getValue(element, "link");
            }

            ListNewsViews.listTitle.add(title);

            ListNewsViews.listLink.add(link);
        }

        ListNewsViews.adapter.notifyDataSetChanged();

    }
}
