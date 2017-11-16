package cn.youcredit.thread.common.service.zmApi.internal.util.json;

public interface JSONErrorListener {
    void start(String text);
    void error(String message, int column);
    void end();
}
