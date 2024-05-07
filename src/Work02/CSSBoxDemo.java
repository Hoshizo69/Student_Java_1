package Work02;

import java.util.Scanner;
public class CSSBoxDemo {
    public static void main(String[] args) {
        System.out.println("testConstrutor():" + (testConstrutor() ? "pass" : "failure"));
        System.out.println("testGetSet():" + (testGetSet() ? "pass" : "failure"));
        testDisplay();
    }
    public static boolean testConstrutor() {
        boolean bRtn01 = false;
        CSSBox firstBox = new CSSBox();
        if (firstBox.getContent().equals("default content")) {
            bRtn01 = true;
        }
        boolean bRtn02 = false;
        CSSBox secondBox = new CSSBox("one line: hi...\rtwo line: Java class \rthree line:......");
        if (secondBox.getWidth() == 21 && secondBox.getHeight() == 3) {
            bRtn02 = true;
        }
        boolean bRtn03 = false;
        CSSBox thirdBox = new CSSBox("one line: hi...\rtwo line: Java class \rthree line:......", 2, 3, 4);
        if (thirdBox.getBorderBottom() == 3 && thirdBox.getBorderLeft() == 3 && thirdBox.getPaddingBottom() == 2
                && thirdBox.getPaddingRight() == 2 && thirdBox.getMarginRight() == 4 && thirdBox.getMarginTop() == 4) {
            bRtn03 = true;
        }
        boolean bRtn04 = false;
        CSSBox forthBox = new CSSBox("one line: hi...\rtwo line: Java class \rthree line:......", 2, 3, 4, 2, 3, 4, 2,
                3, 4, 2, 3, 4, 5, 6);
        if (forthBox.getWidth() == 21 && forthBox.getHeight() == 3 && forthBox.getBorderBottom() == 3
                && forthBox.getBorderLeft() == 4 && forthBox.getPaddingBottom() == 2 && forthBox.getPaddingRight() == 4
                && forthBox.getMarginRight() == 6 && forthBox.getMarginTop() == 3) {
            bRtn04 = true;
        }
        return bRtn01 && bRtn02 && bRtn03 && bRtn04;
    }

    public static boolean testGetSet() {
        boolean bRtn01 = false;
        CSSBox firstBox = new CSSBox();
        firstBox.setWidth(-1);
        firstBox.setHeight(10);
        if (firstBox.getWidth() == 15 && firstBox.getHeight() == 1) {
            bRtn01 = true;
        }
        boolean bRtn02 = false;
        CSSBox secondBox = new CSSBox();
        secondBox.setBorder(6);
        secondBox.setMarginBottom(1);
        secondBox.setPaddingRight(3);
        if(secondBox.getBorderBottom() == 6 && secondBox.getBorderRight() == 6 && secondBox.getMarginBottom() == 1
                && secondBox.getPaddingRight() == 3) {
            bRtn02 = true;
        }
        boolean bRtn03 = false;
        CSSBox thirdBox = new CSSBox();
        thirdBox.setBorder(-6);
        thirdBox.setMarginBottom(-1);
        thirdBox.setPaddingRight(-3);
        if(thirdBox.getBorderBottom() == 0 && thirdBox.getBorderRight() == 0 && thirdBox.getMarginBottom() == 0
                && thirdBox.getPaddingRight() == 0) {
            bRtn03 = true;
        }
        return bRtn01 && bRtn02 && bRtn03;
    }
    public static void testDisplay() {
        Scanner input = new Scanner(System.in);
        int param01 = 0;
        int param02 = 0;
        int param03 = 0;
        char param04 = '*';
        char param05 = '-';
        char param06 = '@';
        System.out.println("testDisplay#1");
        System.out.print("enter border-size:");
        param01 = input.nextInt();
        System.out.print("enter margin-bottom:");
        param02 = input.nextInt();
        System.out.print("enter padding-right:");
        param03 = input.nextInt();
        CSSBox firstBox = new CSSBox();
        firstBox.setBorder(param01);
        firstBox.setMarginBottom(param02);
        firstBox.setPaddingRight(param03);
        firstBox.display();
        CSSBox secondBox = new CSSBox();
        System.out.println("testDisplay#2");
        System.out.print("enter border-size:");
        param01 = input.nextInt();
        System.out.print("enter margin-size:");
        param02 = input.nextInt();
        System.out.print("enter padding-size:");
        param03 = input.nextInt();
        secondBox.setBorder(param01);
        secondBox.setMargin(param02);
        secondBox.setPadding(param03);
        System.out.print("enter padding-char:");
        param04 = input.next().charAt(0);
        System.out.print("enter border-char:");
        param05 = input.next().charAt(0);
        System.out.print("enter margin-char:");
        param06 = input.next().charAt(0);
        String content = "Better late than never.\rWhatever is worth doing at all is worth doing well.\rAction is the proper fruit of knowledge.";
        secondBox.setContent(content);
        secondBox.display(param04,param05,param06);
    }
}

class CSSBox {
    private String content;
    private int width;
    private int height;
    private int paddingTop;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int borderTop;
    private int borderBottom;
    private int borderLeft;
    private int borderRight;
    private int marginTop;
    private int marginBottom;
    private int marginLeft;
    private int marginRight;
    private static final String defaultContent = "default content";//内容默认值

    public CSSBox() {
        // TODO 补全代码，各项属性值都采用默认值
        setContent(defaultContent);
    }

    /**
     * 构造CSSBox 提示：width和height的设置以content为准
     *
     * @param content       内容
     * @param width         宽度
     * @param height        高度
     * @param paddingTop    内边距顶宽
     * @param paddingBottom 内边距底宽
     * @param paddingLeft   内边距左宽
     * @param paddingRight  内边距右宽
     * @param borderTop     边框顶宽
     * @param borderBottom  边框底宽
     * @param borderLeft    边框左宽
     * @param borderRight   边框右宽
     * @param marginTop     外边距顶宽
     * @param marginBottom  外边距底宽
     * @param marginLeft    外边距左宽
     * @param marginRight   外边距右宽
     */
    public CSSBox(String content, int width, int height, int paddingTop, int paddingBottom, int paddingLeft,
                  int paddingRight, int borderTop, int borderBottom, int borderLeft, int borderRight, int marginTop,
                  int marginBottom, int marginLeft, int marginRight) {
        // TODO 补全代码，根据传入参数初始化各成员变量
        setContent(content);
        setWidth(width);
        setHeight(height);
        setPaddingTop(paddingTop);
        setPaddingBottom(paddingBottom);
        setPaddingLeft(paddingLeft);
        setPaddingRight(paddingRight);
        setBorderTop(borderTop);
        setBorderBottom(borderBottom);
        setBorderLeft(borderLeft);
        setBorderRight(borderRight);
        setMarginTop(marginTop);
        setMarginBottom(marginBottom);
        setMarginLeft(marginLeft);
        setMarginRight(marginRight);
    }

    /**
     * 构造CSSBox 提示：width和height的设置以content为准
     *
     * @param width         宽度
     * @param height        高度
     * @param paddingTop    内边距顶宽
     * @param paddingBottom 内边距底宽
     * @param paddingLeft   内边距左宽
     * @param paddingRight  内边距右宽
     * @param borderTop     边框顶宽
     * @param borderBottom  边框底宽
     * @param borderLeft    边框左宽
     * @param borderRight   边框右宽
     * @param marginTop     外边距顶宽
     * @param marginBottom  外边距底宽
     * @param marginLeft    外边距左宽
     * @param marginRight   外边距右宽
     */
    public CSSBox(int width, int height, int paddingTop, int paddingBottom, int paddingLeft, int paddingRight,
                  int borderTop, int borderBottom, int borderLeft, int borderRight, int marginTop, int marginBottom,
                  int marginLeft, int marginRight) {
        // TODO 补全代码，根据传入参数初始化各成员变量，内容采用默认值初始化
        setWidth(width);
        setHeight(height);
        setPaddingTop(paddingTop);
        setPaddingBottom(paddingBottom);
        setPaddingLeft(paddingLeft);
        setPaddingRight(paddingRight);
        setBorderTop(borderTop);
        setBorderBottom(borderBottom);
        setBorderLeft(borderLeft);
        setBorderRight(borderRight);
        setMarginTop(marginTop);
        setMarginBottom(marginBottom);
        setMarginLeft(marginLeft);
        setMarginRight(marginRight);
    }

    /**
     * 构造方法
     *
     * @param content 内容
     */
    public CSSBox(String content) {
        // TODO 补全代码，根据传入内容初始化，其他边距和边框都为0
        setContent(content);
    }

    /**
     * 构造方法
     *
     * @param content     内容
     * @param paddingSize 内边距大小
     * @param borderSize  边框大小
     * @param marginSize  外边距大小
     */
    public CSSBox(String content, int paddingSize, int borderSize, int marginSize) {
        // TODO 补全代码，根据传入参数初始化
        setContent(content);
        setPadding(paddingSize);
        setBorder(borderSize);
        setMargin(marginSize);
    }

    public String getContent() {
        return content;
    }

    /**
     * 内容设置 1.内容设置 2.根据内容调整width和height，以content实际内容为准 2.1.content字符串以'\r'进行分割
     * 2.2.分割后的字符串数量为height 2.3.分割后的最长字符串的长度为width
     *
     * @param content
     */
    public void setContent(String content) {
        // TODO 补全代码
        this.content = content;
        int h = 0, w = 0;
        int flag = 0;
        try {
            while (content.length() > 0) {
                h++;
                if (w < content.substring(0, content.indexOf("\r")).length()) {
                    int count = 0;
                    for (int i = 0; i < (content.substring(0, content.indexOf("\r"))).length(); i++) {
                        if ((content.substring(0, content.indexOf("\r"))).charAt(i) == ' ')
                            count++;
                    }
                    w = (content.substring(0, content.indexOf("\r"))).replace(" ", "").length() + count;
                    content = content.substring(content.indexOf("\r") + 1);
                    flag = 1;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            if (flag == 0)
                w = content.length();
        }
        setHeight(h);
        setWidth(w);
    }

    public int getWidth() {
        return width;
    }

    /**
     * 宽度设置 宽度小于1的，设置宽度为1； 宽度以content内容的实际为准（参见setContent部分）；
     *
     * @param width
     */
    public void setWidth(int width) {
        // TODO 补全代码
        if (content.equals(defaultContent))
            this.width = defaultContent.length();
        else {
            if (width < 1)
                this.width = 1;
            else if (width > this.width)
                this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    /**
     * 高度设置 如果高度不足1，则设置高度为1
     *
     * @param height
     */
    public void setHeight(int height) {
        // TODO 补全代码
        if (height < 1 || content == defaultContent)
            this.height = 1;
        else
            this.height = height;

    }

    public int getPaddingTop() {
        return paddingTop;
    }

    /**
     * 内边距顶距设置 如果参数高度小于0，则设置为0
     *
     * @param paddingTop
     */

    public void setPaddingTop(int paddingTop) {
        // TODO 补全代码
        this.paddingTop = Math.max(paddingTop, 0);
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    /**
     * 内边距顶距设置 如果参数高度小于0，则设置为0
     *
     * @param paddingBottom
     */
    public void setPaddingBottom(int paddingBottom) {
        // TODO 补全代码，参数小于0，则设置为0
        this.paddingBottom = Math.max(paddingBottom, 0);
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        // TODO 补全代码，参数小于0，则设置为0
        this.paddingLeft = Math.max(paddingLeft, 0);
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        // TODO 补全代码，参数小于0，则设置为0
        this.paddingRight = Math.max(paddingRight, 0);
    }

    public int getBorderTop() {
        return borderTop;
    }

    public void setBorderTop(int borderTop) {
        // TODO 补全代码，参数小于0，则设置为0
        this.borderTop = Math.max(borderTop, 0);
    }

    public int getBorderBottom() {
        return borderBottom;
    }

    public void setBorderBottom(int borderBottom) {
        // TODO 补全代码，参数小于0，则设置为0
        this.borderBottom = Math.max(borderBottom, 0);
    }

    public int getBorderLeft() {
        return borderLeft;
    }

    public void setBorderLeft(int borderLeft) {
        // TODO 补全代码，参数小于0，则设置为0
        this.borderLeft = Math.max(borderLeft, 0);
    }

    public int getBorderRight() {
        return borderRight;
    }

    public void setBorderRight(int borderRight) {
        // TODO 补全代码，参数小于0，则设置为0
        this.borderRight = Math.max(borderRight, 0);
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        // TODO 补全代码，参数小于0，则设置为0
        this.marginTop = Math.max(marginTop, 0);
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        // TODO 补全代码，参数小于0，则设置为0
        this.marginBottom = Math.max(marginBottom, 0);
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        // TODO 补全代码，参数小于0，则设置为0
        this.marginLeft = Math.max(marginLeft, 0);
    }

    public int getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(int marginRight) {
        // TODO 补全代码，参数小于0，则设置为0
        this.marginRight = Math.max(marginRight, 0);
    }

    public void setPadding(int size) {
        // TODO 补全代码，设置上下左右内边距都为size
        setPaddingBottom(size);
        setPaddingRight(size);
        setPaddingLeft(size);
        setPaddingTop(size);
    }

    public void setBorder(int size) {
        // TODO 补全代码，设置上下左右边框都为size
        setBorderBottom(size);
        setBorderLeft(size);
        setBorderTop(size);
        setBorderRight(size);
    }

    public void setMargin(int size) {
        // TODO 补全代码，设置上下左右外边距都为size
        setMarginBottom(size);
        setMarginLeft(size);
        setMarginRight(size);
        setMarginTop(size);
    }

    /**
     * 打印盒子模型
     *
     * @param paddingChar 内边距字符
     * @param borderChar  边框字符
     * @param marginChar  外边距字符
     */
    public void display(char paddingChar, char borderChar, char marginChar) {
        // TODO 补全代码
        int w = width + borderLeft * 2 + paddingRight * 2 + marginBottom * 2;
        int h = height + paddingRight * 2 + borderLeft * 2 + marginBottom * 2;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i < marginTop || i >= h - marginBottom)
                    //仅输出外边
                    System.out.print(marginChar);
                else if (i < marginTop + borderTop || i < h - marginBottom && i >= h - borderBottom - marginBottom) {
                    //输出外边与边框
                    if (j < marginLeft || j >= w - marginRight)
                        System.out.print(marginChar);
                    else
                        System.out.print(borderChar);
                } else if (i >= marginTop + borderTop && i < marginTop + borderTop + paddingTop || i < h - marginBottom - borderBottom && i >= h - borderBottom - marginBottom - paddingBottom) {
                    //输出外边边框与内边
                    if (j < marginLeft || j >= w - marginRight)
                        System.out.print(marginChar);
                    else if (j >= marginLeft && j < marginLeft + borderLeft || j >= w - marginRight - borderRight && j < w - marginRight) {
                        System.out.print(borderChar);
                    } else if (j >= marginLeft + borderLeft && j < marginLeft + borderLeft + paddingLeft || j >= w - marginRight - borderRight - paddingRight && j < w - marginRight - borderRight) {
                        System.out.print(paddingChar);
                    } else
                        System.out.print(paddingChar);
                } else {
                    if (j < marginLeft || j >= w - marginRight)
                        System.out.print(marginChar);
                    else if (j >= marginLeft && j < marginLeft + borderLeft || j >= w - marginRight - borderRight && j < w - marginRight) {
                        System.out.print(borderChar);
                    } else if (j >= marginLeft + borderLeft && j < marginLeft + borderLeft + paddingLeft || j >= w - marginRight - borderRight - paddingRight && j < w - marginRight - borderRight) {
                        System.out.print(paddingChar);
                    } else {
                        try {
                            System.out.print(content.substring(0, content.indexOf("\r")));
                            j += content.substring(0, content.indexOf("\r")).length();
                            content = content.substring(content.indexOf("\r") + 1);
                            while (j < w - paddingLeft - borderLeft - marginLeft) {
                                System.out.print(" ");
                                j++;
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.print(content);
                            j += content.length();
                            while (j < w - paddingLeft - borderLeft - marginLeft) {
                                System.out.print(" ");
                                j++;
                            }
                        }
                        j--;
                    }
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * 控制台打印盒子，默认图标打印。内边为'*'，边框为'-'，外边为'@'
     */
    public void display() {
        // TODO 补全代码
        int w = width + borderLeft * 2 + paddingRight  ;
        int h = height + paddingRight  + borderLeft  + marginBottom ;
        char marginChar = '@',borderChar = '-',paddingChar = '*';
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i < borderLeft || i >= borderLeft + 1 && i < borderLeft*2 + 1)
                    System.out.print(borderChar);
                else if (i == borderLeft) {
                    for (int k = 0;k < w;k++){
                        if (k < borderLeft || k >= w - borderLeft)
                            System.out.print(borderChar);
                        else if (k >= borderLeft && k < borderLeft + defaultContent.length()) {
                            System.out.print(defaultContent);
                            k += defaultContent.length() - 1;
                        }else
                            System.out.print(paddingChar);
                    }
                    j += w;
                }else if (i >= h - marginBottom){
                    System.out.print(marginChar);
                }else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public String getDisplayContent() {
        // TODO 补全代码，返回display打印到控制台上的内容字符串
        return content;
    }

    public String getDisplayContent(char paddingChar, char borderChar, char marginChar) {
        // TODO 补全代码，根据传入的符号参数返回display打印到控制台上的内容字符串
        return content;
    }
}

