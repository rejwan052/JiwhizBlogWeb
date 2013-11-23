/* 
 * Copyright 2013 JIWHIZ Consulting Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jiwhiz.blog.domain.post.impl;

import javax.inject.Inject;

import com.jiwhiz.blog.domain.account.UserAccount;
import com.jiwhiz.blog.domain.post.SlidePost;
import com.jiwhiz.blog.domain.post.SlidePostRepository;
import com.jiwhiz.blog.domain.post.SlidePostService;
import com.jiwhiz.blog.domain.post.StyleType;
import com.jiwhiz.blog.domain.system.CounterService;

/**
 * Implementation for SlidePostService.
 * 
 * @author Yuan Ji
 * 
 */
public class SlidePostServiceImpl implements SlidePostService {

    public static final String SLIDE_POST_ID_PREFIX = "slide";

    private final SlidePostRepository slidePostRepository;

    private final CounterService counterService;

    @Inject
    public SlidePostServiceImpl(SlidePostRepository slidePostRepository, CounterService counterService) {
        this.slidePostRepository = slidePostRepository;
        this.counterService = counterService;
    }

    @Override
    public SlidePost createSlide(UserAccount author, StyleType style, String title, String content, String path) {
        String postId = SLIDE_POST_ID_PREFIX + this.counterService.getNextSlidePostIdSequence();
        SlidePost slidePost = new SlidePost(postId, author, style, title, content, path);
        return slidePostRepository.save(slidePost);
    }
}
