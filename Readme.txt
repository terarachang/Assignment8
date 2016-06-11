103062227 張婷雲 Assignment 8 

1.brief explanation

總共分為三個page：輸入ip的頁面、計算機的輸入頁面、計算機的結果呈現頁面。
a.)輸入ip的頁面(ip_page.xml)依照助教給的SocketSample，但把原本的onclick拿掉，
   並在ipSend.setOnClickListener裡加上jumpToMainLayout();
   讓使用者輸完ip按下按鈕後就可以進入計算機的輸入頁面。
   
b.)計算機的輸入頁面(activity_main.xml)依照助教給的AndroidPratice_ANS，
   jumpToMainLayout() 設置了button和textfield；onClick(View v)則在輸入完
   按下送出按鈕時執行，在此method裡有out.write(ans)，將答案送回server；
   有jumpToResultLayout(ans)，讓答案在下一頁顯示。
   
c.)結果呈現的頁面(result_page.xml)，在jumpToResultLayout(String resultStr)裡
   顯示答案與返回按鈕。return_button.setOnClickListener裡的jumpToMainLayout();
   使按下按鈕後能返回計算機的輸入頁面。

d.)Server頁面Server extends JFrame，用JLabel顯示傳回server的答案。
   用while(true)包住setText使label能動態更新。

2.problem I encountered and how to solve the problem

a.)一開始我Server端接收訊息時沒有用while包住，導致只會收到第一次的答案。
   印出發現問題後找出以前socket的code，決定用while(true)包住in.read(b)來解決。
b.)我用VCS一直push不上github，所以我就改用慣用的git bash來上傳。