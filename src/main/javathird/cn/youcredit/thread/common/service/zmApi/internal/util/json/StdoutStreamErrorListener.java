package cn.youcredit.thread.common.service.zmApi.internal.util.json;

public class StdoutStreamErrorListener extends BufferErrorListener {
    
    public void end() {
        System.out.print(buffer.toString());
    }
}
