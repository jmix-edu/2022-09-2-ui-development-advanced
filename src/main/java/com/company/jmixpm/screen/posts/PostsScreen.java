package com.company.jmixpm.screen.posts;

import com.company.jmixpm.entity.Post;
import com.company.jmixpm.entity.PostService;
import com.company.jmixpm.screen.userinfo.UserInfoScreen;
import io.jmix.core.LoadContext;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Table;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(path = "posts")
@UiController("PostsScreen")
@UiDescriptor("posts-screen.xml")
public class PostsScreen extends Screen {

    @Autowired
    private PostService postService;

    @Autowired
    private ScreenBuilders screenBuilders;

    @Autowired
    private Table<Post> postsTable;

    @Install(to = "postsDl", target = Target.DATA_LOADER)
    private List<Post> postsDlLoadDelegate(LoadContext<Post> loadContext) {
        return postService.fetchPosts(
                loadContext.getQuery().getFirstResult(),
                loadContext.getQuery().getMaxResults());
    }

    @Install(to = "pagination", subject = "totalCountDelegate")
    private Integer paginationTotalCountDelegate() {
        return postService.fetchPosts().size();
    }

    @Install(to = "userInfoScreenFacet", subject = "screenConfigurer")
    private void userInfoScreenFacetScreenConfigurer(UserInfoScreen userInfoScreen) {
        Post selected = postsTable.getSingleSelected();
        if (selected == null || selected.getUserId() == null) {
            return;
        }

        userInfoScreen.setUserId(selected.getUserId());
    }
}