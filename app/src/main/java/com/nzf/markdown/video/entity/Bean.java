package com.nzf.markdown.video.entity;

/**
 * Created by joseph on 2017/12/1.
 */

public class Bean{

    private int result;
    private DataBean data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean<T> extends Bean{

        private int count;
        private T notes;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public T getNotes() {
            return notes;
        }

        public void setNotes(T notes) {
            this.notes = notes;
        }
    }
}
