package Maven_TestNg.Maven_TestNg;


import java.util.ArrayList;
import java.util.List;

import org.testng.internal.collections.Pair;

class RecentlyPlayedStoreTest {
    private int songId;
    private String title;
    private String artist;
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

    // Constructor, getters, and setters
    // ...

}

class User {
    private int userId;
    private String username;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

    // Constructor, getters, and setters
    // ...
}

public class RecentlyPlayedStore {
    private int capacity;
    private List<Pair<User, RecentlyPlayedStoreTest>> recentlyPlayedSongs;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        recentlyPlayedSongs = new ArrayList<>();
    }

    public void addPlayedSong(User user, RecentlyPlayedStoreTest song) {
        if (recentlyPlayedSongs.size() >= capacity) {
            recentlyPlayedSongs.remove(0);
        }
        recentlyPlayedSongs.add(new Pair<>(user, song));
    }

    public List<RecentlyPlayedStoreTest> getRecentlyPlayedSongs(User user) {
        List<RecentlyPlayedStoreTest> userSongs = new ArrayList<>();
        for (Pair<User, RecentlyPlayedStoreTest> pair : recentlyPlayedSongs) {
            if (pair.first().equals(user)) {
                userSongs.add(pair.second());
            }
        }
        return userSongs;
    }
}