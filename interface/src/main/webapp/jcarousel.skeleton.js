var index = 0;
var dataSet =
        [
            {'imagePath': '../_shared/img/img1.jpg',
                'description': 'sd habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum'
            },
            {'imagePath': '../_shared/img/img2.jpg',
                'description': 's habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum'
            },
            {'imagePath': '../_shared/img/img3.jpg',
                'description': 'f habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum'
            },
            {'imagePath': '../_shared/img/img4.jpg',
                'description': 'r habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum'
            },
            {'imagePath': '../_shared/img/img5.jpg',
                'description': 'g habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum'
            },
            {'imagePath': '../_shared/img/img6.jpg',
                'description': 'y habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum'
            }
        ];
(function ($) {
    $(function () {
        /*
         Carousel initialization
         */

        var content = '<ul>';
        $.each(dataSet, function (i) {
            content += '<li><img src="' + this.imagePath + '" alt="' + i + '"></li>';
        });
        content += '</ul>';
        //console.log(content);
        $('.jcarousel').html(content);

        $('.jcarousel')
                .jcarousel({});

        $('.jcarousel-prev').click(function () {

            if (dataSet[index - 1] != undefined) {
                index--;
                loadData();
            }
        });

        $('.jcarousel-next').click(function () {

            if (dataSet[index + 2] != undefined) {
                index++;
                loadData();
            }


        });
        /*
         Pagination initialization
         */
        $('.jcarousel-pagination')
                .on('jcarouselpagination:active', 'a', function () {
                    $(this).addClass('active');
                })
                .on('jcarouselpagination:inactive', 'a', function () {
                    $(this).removeClass('active');
                })
                .jcarouselPagination({
                    'perPage': 2,
                    'maxPage': 20,
                    // Options go here
                    'item': function (page, carouselItems) {
                        return '<a onclick="loadDataPage(' + page + ')">' + page + '</a>>>';
                    }
                });
    });

})(jQuery);


function loadData() {

    var content = '<ul>';
    for (var i = index; i < (index + 3); i++) {
        if (dataSet[i] != undefined) {
            content += '<li><img src="' + dataSet[i].imagePath + '" alt="' + i + '"></li>';
        }
    }

    content += '</ul>';
    $('.jcarousel').html(content);
    $('.jcarousel').jcarousel('reload');

}

function loadDataPage(page) {
    index = ((page - 1) * 3);
    var content = '<ul>';
    for (var i = ((page - 1) * 3); i < ((page - 1) * 3) + 3; i++) {
        if (dataSet[i] != undefined) {
            content += '<li><img src="' + dataSet[i].imagePath + '" alt="' + i + '"></li>';
        }
    }

    content += '</ul>';
    $('.jcarousel').html(content);
    $('.jcarousel').jcarousel('reload');
}