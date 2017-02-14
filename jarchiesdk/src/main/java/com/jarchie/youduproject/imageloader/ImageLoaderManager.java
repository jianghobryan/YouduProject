package com.jarchie.youduproject.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.jarchie.youduproject.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.imageloader
 * 文件名:   ImageLoaderManager
 * 创建者:   Jarchie
 * 创建时间: 17/2/14 下午2:38
 * 描述:     初始化UniversalImageLoader,用来加载图片
 */

public class ImageLoaderManager {
    //标明我们的UIL最多可以有多少条线程
    private static final int THREAD_COUNT = 4;
    //标明我们图片加载的优先级
    private static final int PROPRITY = 2;
    //标明UIL可以最多缓存多少图片
    private static final int DISK_CACHE_SIZE = 50 * 1024;
    //连接的超时时间
    private static final int CONNECTION_TIME_OUT = 5 * 1000;
    //读取的超时时间
    private static final int READ_TIME_OUT = 30 * 1000;
    //ImageLoader对象
    private static ImageLoader mImageLoader = null;
    //私有静态本类对象
    private static ImageLoaderManager mInstance = null;

    /**
     * 单例模式的私有构造方法
     *
     * @param context
     */
    private ImageLoaderManager(Context context) {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPoolSize(THREAD_COUNT) //配置图片下载线程的最大数量
                .threadPriority(Thread.NORM_PRIORITY - PROPRITY) //线程优先级
                .denyCacheImageMultipleSizesInMemory() //防止缓存多套尺寸图片到内存中
                .memoryCache(new WeakMemoryCache()) //使用若引用内存缓存
                .diskCacheSize(DISK_CACHE_SIZE) //分配硬盘缓存大小
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //使用md5命名文件
                .tasksProcessingOrder(QueueProcessingType.LIFO) //图片下载顺序
                .defaultDisplayImageOptions(getDefaultOptions()) //默认的图片加载Options
                .imageDownloader(new BaseImageDownloader(context
                        , CONNECTION_TIME_OUT, READ_TIME_OUT)) //设置图片下载器
                .writeDebugLogs() //debug环境下会输出日志
                .build();
        ImageLoader.getInstance().init(configuration);
        mImageLoader = ImageLoader.getInstance();
    }

    /**
     * 实现我们默认的Options
     *
     * @return
     */
    private DisplayImageOptions getDefaultOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.xadsdk_img_error) //图片地址为空时加载该图片
                .showImageOnFail(R.drawable.xadsdk_img_error) //图片下载失败时加载该图片
                .cacheInMemory(true) //设置图片可以缓存在内存
                .cacheOnDisk(true) //设置图片可以缓存在硬盘
                .bitmapConfig(Bitmap.Config.RGB_565) //使用的解码类型
                .decodingOptions(new BitmapFactory.Options()) //图片解码配置
                .build();
        return options;
    }

    /**
     * 提供一个公共的静态的返回本类对象的方法
     *
     * @param context
     * @return 本类对象
     */
    public static ImageLoaderManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ImageLoaderManager.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 加载图片API
     *
     * @param imageView
     * @param url
     * @param options
     * @param listener
     */
    public void displayImage(ImageView imageView, String url,
                             DisplayImageOptions options,
                             ImageLoadingListener listener) {
        if (mImageLoader != null) {
            mImageLoader.displayImage(url, imageView, options, listener);
        }
    }

    /**
     * 重载三个参数
     *
     * @param imageView
     * @param url
     * @param listener
     */
    public void displayImage(ImageView imageView, String url,
                             ImageLoadingListener listener) {
        displayImage(imageView, url, null, listener);
    }

    /**
     * 重载两个参数,最简单的调用
     *
     * @param imageView
     * @param url
     */
    public void displayImage(ImageView imageView, String url) {
        displayImage(imageView, url, null);
    }
}
