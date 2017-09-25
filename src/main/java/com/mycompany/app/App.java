package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
import java.util.Arrays;
public class App
{
    public static boolean search(ArrayList<String> array,String input, int n) {
	int counter = 0;
	if(array==null)
		return false;
      	for (int i = 0; i < array.size(); i++) {
		if(array.get(i).equalsIgnoreCase(input))
			counter++;
      	}
      	if(counter == n)
    		  return true;
      	return false;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            inputList.add(sc1.next().replaceAll("\\s",""));
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          
	  String input3 = req.queryParams("input3");
	  int input3AsInt = Integer.parseInt(input3);
          boolean result = App.search(inputList, input2 , input3AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 5000; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

