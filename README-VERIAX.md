# VeriaX - Element X Android HTTP Edition

**VeriaX** هو نسخة معدلة من Element X Android المصممة لقبول اتصالات HTTP من IP محدد للاستخدام المحلي.

## المميزات 🚀

✅ **تصميم حديث** - نفس تصميم Element X الجميل والنيون
✅ **HTTP من IP محلي** - يقبل HTTP فقط من `192.168.100.80`
✅ **HTTPS محمي** - جميع الاتصالات الأخرى تبقى HTTPS آمنة
✅ **تطبيق محادثات** - Matrix protocol client عالي الجودة

## التعديلات الرئيسية 🔧

تم تعديل الملفات التالية لقبول HTTP من IP المحلي فقط:

### 1. `UrlUtils.kt`
```kotlin
fun String.ensureProtocol(): String {
    return when {
        isEmpty() -> this
        !startsWith("http") -> {
            if (contains("192.168.100.80")) {
                "http://$this"  // HTTP for local IP
            } else {
                "https://$this" // HTTPS for others
            }
        }
        else -> this
    }
}
```

### 2. `IntegrationManagerConfigExtractor.kt`
- يسمح بـ HTTP للـ IP المحلي
- HTTPS لجميع الخوادم الأخرى

### 3. `UrlsExtractor.kt`
- استخراج الروابط من الرسائل
- دعم HTTP من IP المحلي

## الاستخدام 📱

### متطلبات البناء:
- Android SDK 26+
- Kotlin 1.8+
- Gradle 7.0+

### البناء:
```bash
./gradlew assembleDebug
```

### التشغيل على محاكي:
```bash
./gradlew installDebug
```

## الاتصال بـ Server محلي 🖥️

عند تسجيل الدخول:
```
Homeserver URL: http://192.168.100.80:8008
```

**ملاحظة:** يعمل HTTP فقط من هذا الـ IP المحدد!

## الترخيص 📄

هذا المشروع مرخص تحت **AGPL-3.0**
الأصلي: [Element Android](https://github.com/element-hq/element-android)

## التحذيرات ⚠️

⚠️ **هذا للاستخدام المحلي فقط**
⚠️ **لا تستخدم في الإنتاج**
⚠️ **HTTP غير آمن للبيانات الحساسة**

---

**المطور الأصلي:** Element Team
**المعدّل:** VeriaX Team (Ghoust71)
**التاريخ:** 2026
