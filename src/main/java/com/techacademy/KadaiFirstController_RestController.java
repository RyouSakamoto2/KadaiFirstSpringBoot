package com.techacademy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController_RestController {

    //dispDayOfWeek
    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable String val1) {

    String res01 = new String();
    SimpleDateFormat sdf01 = new SimpleDateFormat("yyyyMMdd"); // Date型で"yyyyMMdd"形式を表記するフォーマット(sdf01)
    SimpleDateFormat sdf02 = new SimpleDateFormat("EEEE", Locale.ENGLISH); // Date型で曜日（英語）を表記するフォーマット(sdf02)
    sdf01.setLenient(false); // 存在しない日付が入力された場合の前提処理

    if(val1.length() != 8) { // 8桁以外の数値で入力がされた場合の例外処理
    return "8桁（YYYYMMDD）の数値で入力してください";
    }else{
    try{
    Date date = sdf01.parse(val1); // 一旦、Date型に変換
    res01 = sdf02.format(date);
    // 存在しない日付が入力された場合の例外処理
    }catch (ParseException e) {
    return "Date型に変換できません";
    }
    return res01;
    }
    }

    //calcPlus
    @GetMapping("/plus/{val2}/{val3}")
    public String calcPlus(@PathVariable int val2, @PathVariable int val3) {
    int res02 = 0;
    res02 = val2 + val3;
    return "" + res02;
    }
    @GetMapping("/minus/{val2}/{val3}") //calcMinus
    public String calcMinus(@PathVariable int val2, @PathVariable int val3) {
    int res03 = 0;
    res03 = val2 - val3;
    return "" + res03;
    }
    @GetMapping("/times/{val2}/{val3}") //calcTimes
    public String calcTimes(@PathVariable int val2, @PathVariable int val3) {
    int res04 = 0;
    res04 = val2 * val3;
    return "" + res04;
    }
    //calcDivide
    @GetMapping("/divide/{val2}/{val3}")
    public String calcDivide(@PathVariable int val2, @PathVariable int val3) {
    int res05 = 0;
    if(val3 == 0) {
    return ("0で割ることは許されていません");
    }else{
    res05 = val2 / val3;
    return "" + res05;
    }
    }
}