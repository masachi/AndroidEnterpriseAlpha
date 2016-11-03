package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by byyoung:专辑图片 on 2016/11/1.
 */
public class AlbumEntity implements Serializable{
    private List<AlbumPicEntity> albums;
    public AlbumEntity(){
        albums = new ArrayList<AlbumPicEntity>();
    }

    public List<AlbumPicEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumPicEntity> albums) {
        this.albums = albums;
    }

    public static class AlbumPicEntity{
        private String album_url;

        public String getAlbum_url() {
            return album_url;
        }

        public void setAlbum_url(String album_url) {
            this.album_url = album_url;
        }
    }
}
