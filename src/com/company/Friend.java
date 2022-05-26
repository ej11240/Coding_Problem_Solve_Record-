package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {

        Queue<Friend> fl = (Queue<Friend>) this.getFriends().stream().collect(Collectors.toList());

        Queue<Friend> alreay= new LinkedList<>();

        Queue<Friend> tofind= new LinkedList<>();
        tofind.add(this);
        alreay.add(this);
//        while qu: # 큐에 처리할 사람이 남아 있는 동안
//        p = qu.pop(0) # 큐에서 처리 대상을 한 명 꺼내 print(p) # 이름을 출력하고 for x in g[p]: # 그의 친구들 중에 if x not in done: # 아직 큐에 추가된 적이 없는 사람을 qu.append(x) # 큐에 추가하고 done.add(x) # 집합에도 추가
//


        return true;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}
