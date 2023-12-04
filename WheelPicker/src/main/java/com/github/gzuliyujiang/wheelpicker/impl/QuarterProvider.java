/*
 * Copyright (c) 2016-present 贵州纳雍穿青人李裕江<1032694760@qq.com>
 *
 * The software is licensed under the Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *     http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR
 * PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.github.gzuliyujiang.wheelpicker.impl;

import androidx.annotation.NonNull;

import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @author 贵州山野羡民（1032694760@qq.com）
 * @since 2021/6/7 12:22
 */
public class QuarterProvider implements LinkageProvider {

    private List<String> years = new ArrayList<String>();

    @Override
    public boolean firstLevelVisible() {
        return true;
    }

    @Override
    public boolean thirdLevelVisible() {
        return false;
    }


    @NonNull
    @Override
    public List<String> provideFirstData() {
        int defaultYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 10; i >= 0; i--) {
            int year = (defaultYear - i);
            years.add((year + "年"));
        }
        return years;
    }

    @NonNull
    @Override
    public List<String> linkageSecondData(int firstIndex) {
        return Arrays.asList("第一季度", "第二季度", "第三季度", "第四季度");
    }

    @NonNull
    @Override
    public List<String> linkageThirdData(int firstIndex, int secondIndex) {
        return new ArrayList<>();
    }

    @Override
    public int findFirstIndex(Object firstValue) {
        int size = years.size();
        return size >= 1 ? size - 1 : 0;
    }

    @Override
    public int findSecondIndex(int firstIndex, Object secondValue) {
        return 0;
    }

    @Override
    public int findThirdIndex(int firstIndex, int secondIndex, Object thirdValue) {
        return 0;
    }

}
