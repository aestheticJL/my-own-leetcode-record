/*
355. 设计推特
设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户
示例:

Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
twitter.getNewsFeed(1);

// 用户1关注了用户2.
twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
twitter.getNewsFeed(1);

### 解题思路
记住每次都要初始化，以及细节的处理即可。
设计题还是蛮有意思的，可以反复提交的情况下设计题难度降低不少。
执行用时 :47 ms, 在所有 Java 提交中击败了44.30%的用户
内存消耗 :45.2 MB, 在所有 Java 提交中击败了10.00%的用户
 */
package design.设计推特;

import java.util.*;

class Twitter {
    /**
     * Initialize your data structure here.
     */
    class Twitte {
        Integer userId;
        Integer twitterId;

        public Twitte(Integer userId, Integer twitterId) {
            this.userId = userId;
            this.twitterId = twitterId;
        }
    }

    public Twitter() {
        twitters = new ArrayList<>();
        user_user = new HashMap<>();
    }

    static List<Twitte> twitters;
    static Map<Integer, HashSet<Integer>> user_user;

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        twitters.add(new Twitte(userId, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> users = new HashSet<>();
        if (user_user.get(userId) != null) {
            users = user_user.get(userId);
        }
        users.add(userId);
        for (int i = twitters.size() - 1; i >= 0; i--) {
            Twitte twitter = twitters.get(i);
            if (users.contains(twitter.userId)) {
                result.add(twitter.twitterId);
            }
            if (result.size() == 10) {
                return result;
            }
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> temp = new HashSet<>();
        if (user_user.get(followerId) != null) {
            temp = user_user.get(followerId);
        }
        temp.add(followeeId);
        user_user.put(followerId, temp);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> temp = new HashSet<>();
        if (user_user.get(followerId) != null) {
            temp = user_user.get(followerId);
        }
        temp.remove(followeeId);
        user_user.put(followerId, temp);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 * public static void main(String[] args) {
 * Twitter obj = new Twitter();
 * obj.postTweet(1, 5);
 * obj.getNewsFeed(1);
 * obj.follow(1, 2);
 * obj.postTweet(2, 6);
 * obj.getNewsFeed(1);
 * obj.unfollow(1, 2);
 * obj.getNewsFeed(1);
 * }
 */