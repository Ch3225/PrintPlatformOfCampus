var gulp = require('gulp');
var fileinclude  = require('gulp-file-include');

gulp.task('fileinclude', async() => {
    gulp.src('src/pages/**.html')
        .pipe(fileinclude({
          prefix: '@@',
          basepath: '@file',
		  indent:true
        }))
    .pipe(gulp.dest('dist/pages'));
});