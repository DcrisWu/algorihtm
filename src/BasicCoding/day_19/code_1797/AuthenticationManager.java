package BasicCoding.day_19.code_1797;

import Pack.Pair;

import java.util.*;

/**
 * completion time = 2022.10.12
 */
public class AuthenticationManager {
    private int timeToLive;
    //    private Map<String, Integer> map;
    private Map<String, Integer> byToken;
    private Map<Integer, String> byTime;
    //queue存的是过期时间
//    Queue<Pair<String, Integer>> queue;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        byToken = new HashMap<>();
        byTime = new HashMap<>();
//        queue = new LinkedList<>();
    }

    public void generate(String tokenId, int currentTime) {
//        Pair<String, Integer> pair = new Pair<>(tokenId, currentTime);
//        pairs.putIfAbsent(tokenId, pair);
//        queue.add(pair);
        byToken.putIfAbsent(tokenId, currentTime);
        byTime.putIfAbsent(currentTime, tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        if(byToken.containsKey(tokenId)){
            if (byToken.get(tokenId) + timeToLive > currentTime) {
                byTime.remove(byToken.get(tokenId));
                byToken.replace(tokenId, currentTime);
                byTime.putIfAbsent(currentTime, tokenId);
            } else {
                byTime.remove(byToken.get(tokenId));
                byToken.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        Object[] objects = byTime.keySet().toArray();
        Arrays.sort(objects);
        for (Object object : objects) {
            if ((int) object + timeToLive <= currentTime) {
                String s = byTime.get((int) object);
                byTime.remove((int) object);
                byToken.remove(s);
            } else {
                break;
            }
        }
        return byToken.size();
    }
}
