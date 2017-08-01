package com.celnet.dc.common.util;

/**
 * 把时间区间转换为特定进制.
 * <p>把一周的时间转换为秒</p>
 * <pre>
 *  AnalyzeTime.WEEK.second();
 * </pre>
 * <p>还可以转换为其他的进制，比如分钟毫秒等</p>
 *
 * @author will Tong
 */
public enum AnalyzeTime {
    MILLISECOND(1),SECOND(2),MINUTE(3),HOUR(4),DAY(5),WEEK(6),MONTH(7),YEAR(8);

    private int type;

    AnalyzeTime(int type){
        this.type=type;
    }

    public int second(){
        switch (type){
            case 3:
                return 60;
            case 4:
                return 3600;
            case 5:
                return 86400;
            case 6:
                return 604800;
            case 7:
                return 2592000;
            case 8:
                return 31536000;
        }
        return 0;
    }

    public int second(int multiplier){
        switch (type){
            case 3:
                return 60*multiplier;
            case 4:
                return 3600*multiplier;
            case 5:
                return 86400*multiplier;
            case 6:
                return 604800*multiplier;
            case 7:
                return 2592000*multiplier;
            case 8:
                return 31536000*multiplier;
        }
        return 0;
    }

    public long millisecond(){
        switch (type){
            case 3:
                return 60000L;
            case 4:
                return 3600000L;
            case 5:
                return 86400000L;
            case 6:
                return 604800000L;
            case 7:
                return 2592000000L;
            case 8:
                return 31536000000L;
        }
        return 0;
    }

    public long millisecond(int multiplier){
        switch (type){
            case 3:
                return 60000L*multiplier;
            case 4:
                return 3600000L*multiplier;
            case 5:
                return 86400000L*multiplier;
            case 6:
                return 604800000L*multiplier;
            case 7:
                return 2592000000L*multiplier;
            case 8:
                return 31536000000L*multiplier;
        }
        return 0;
    }
}
