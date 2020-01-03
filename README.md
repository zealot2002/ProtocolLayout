# ProtocolLayout
ProtocolLayout
Preview：
https://raw.githubusercontent.com/zealot2002/ProtocolLayout/master/protocol.jpg

Usage:
<pre><code>
ProtocolLayout ptl = view.findViewById(R.id.ptl);
        List<String> list = new ArrayList<>();
        list.add("我已经阅读并同意");
        for(int i=0;i<protocolBeanList.size();i++){
            list.add(protocolBeanList.get(i).name);
        }

        ptl.setData(16, //字号
                R.color.text_black2,//tips颜色
                R.color.blue,//protocol颜色
                1.5f,//行间距倍数
                list, //protocol list
                new ProtocolLayout.OnProtocolClickListener() {
                    @Override
                    public void onClicked(int position) {
                        try {
                            Toast.show("第"+position+"个协议被点击了");
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
</code></pre>
