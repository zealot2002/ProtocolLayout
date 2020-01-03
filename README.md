# ProtocolLayout
Preview：
![screenshot](https://raw.githubusercontent.com/zealot2002/ProtocolLayout/master/protocol.jpg)


Usage:

    ProtocolLayout ptl = findViewById(R.id.ptl);
        List list = new ArrayList<>();
        list.add("我已经阅读并同意");
        list.add("《第一个xxx协议》");
        list.add("《第二个xxx协议》");
        list.add("《第三个xxx协议》");
        list.add("《第四个xxx协议》");

        ptl.setData(16, //字号
                R.color.colorAccent,//tips颜色
                R.color.colorPrimary,//protocol颜色
                1.5f,//行间距倍数
                list, //protocol list
                new ProtocolLayout.OnProtocolClickListener() {
                    @Override
                    public void onClicked(int position) {
                        try {
                            Log.e("me","第"+position+"个协议被点击了");
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
