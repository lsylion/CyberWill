package com.example.myapplication3.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppDatabaseCallback(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                val defaultAnswers = listOf(
                    // 火象 INTJ
                    Answer (
                        content = "你有着火象星座的炽热激情，这股热情为你 INTJ 的理性规划注入源源不断的动力，面对目标时，如燃烧的火焰般势不可挡，凭借深刻洞察和严谨策略，必能让想法落地开花，在追求梦想的道路上留下闪耀印记。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "在团队中，你宛如一团引领方向的火焰，火象的热情让你能积极带动氛围，INTJ 的远见卓识又使你可以高瞻远瞩地布局，带领大家冲破阻碍，向着成功稳步迈进，成为团队里的智慧灯塔。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "生活里的你，火象特质让你对新体验充满渴望，INTJ 的冷静思考则确保你不会盲目冲动，两者结合使你无论是探索未知还是处理日常事务，都能张弛有度，以独特的魅力影响身边的一切。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INTJ"
                    ),

                    // 火象 INTP
                    Answer (
                        content = "作为火象的 INTP，你那如火的活力激发着你对世间万物的好奇，驱使你不断去探索、思考，用独特的逻辑和创新思维，像火焰照亮黑暗般，解开一个个复杂谜题，让知识的光芒闪耀。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "在社交场合，你虽有着火象的热情外向一面，但 INTP 的理性又让你保持独立思考，与人交流时，常能抛出新奇观点，如同跳跃的火苗，点燃大家思维的火花，带来别样的思想碰撞。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "面对挑战，你这火象的 INTP 不会畏惧，而是燃起内心探索的火焰，运用自己擅长的分析能力，冷静拆解问题，凭借灵活的思维，找到解决路径，在挑战中绽放智慧光彩。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INTP"
                    ),


                    // 火象 ENTJ
                    Answer (
                        content = "你身上兼具火象星座的果敢和 ENTJ 的领导力，就像熊熊烈火，在面对复杂局势时，果断决策，凭借强大的气场和组织能力，引领众人朝着目标奋勇前行，燃出一片辉煌成就。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这火象的 ENTJ 是当之无愧的核心，用热情去鼓舞士气，以 ENTJ 的战略眼光和高效执行力，有条不紊地安排工作，让整个团队如烈火燎原般，攻克一个个难关，迈向胜利。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "生活中的你，火象的冲劲促使你不断追求更高目标，ENTJ 的理性判断保障行动的正确方向，无论大事小事，你都能把控全局，像一团炽热却有序的火焰，照亮生活的每一处。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENTJ"
                    ),

                    //火象 ENTP
                    Answer (
                        content = "身为火象的 ENTP，你那如火的热情让你对新事物充满无尽兴趣，ENTP 的机智敏捷又使你总能快速发现新奇角度，在各种场合中，像灵动的火苗，跳跃出不同寻常的想法，给周围带来充满活力的氛围。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "在社交中，你凭借火象的外向开朗和 ENTP 的幽默风趣，轻易就能成为焦点，像一把热情的火炬，吸引着众人围绕，大家一起在欢声笑语中交流思想，开拓视野，感受你的独特魅力。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这火象的 ENTP 会燃起斗志，用 ENTP 的创新思维和善于应变的能力，从多角度去突破困境，如同火焰突破重重阻碍，继续闪耀前行，书写精彩故事。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENTP"
                    ),

                    Answer (
                        content = "你有着火象星座的积极活力，同时 ISTJ 的严谨踏实让你做事有条不紊，面对任务时，像稳定燃烧的火焰，一步一个脚印，凭借对规则的严格遵守和认真负责的态度，确保每项工作都能高质量完成。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "在团队里，你这火象的 ISTJ 是可靠的后盾，用热情去支持队友，ISTJ 的细心和坚持原则，又能保证团队工作按部就班，避免差错，如同坚固的防火墙，守护着团队的稳定运作。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "生活中，火象的热情让你积极对待生活，ISTJ 的条理分明使你能把生活安排得井然有序，无论是家庭琐事还是个人规划，你都能稳稳当当，像一团温暖而有序的火，给身边人带来安心。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISTJ"
                    ),

                    Answer (
                        content = "作为火象的 ISFJ，你既有火般的热情，又有着 ISFJ 的温柔体贴，在与人相处时，像温暖的炉火，默默地关心他人，用细致入微的关怀，给身边的人带来如阳光般的温暖，让人倍感温馨。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "在团队中，你这火象的 ISFJ 虽低调但不可或缺，火象的活力让你积极承担任务，ISFJ 的耐心和专注，能把每项工作都处理得妥妥当当，宛如柔和的烛光，照亮团队中每一个需要的角落。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借火象的积极心态去拥抱生活，ISFJ 的善于照顾他人使你总是把身边人的需求放在首位，你就像一团贴心的小火苗，用爱与关怀，让生活充满浓浓的人情味。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISFJ"
                    ),

                    Answer (
                        content = "你身上融合了火象星座的冲劲和 ESTJ 的果断干练，面对目标时，像烈火般勇往直前，凭借强大的执行力和对秩序的维护，能够高效地组织资源，确保计划顺利推进，达成预期成果。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这火象的 ESTJ 是强有力的领导者，用热情去激励队员，以 ESTJ 的严谨管理和明确指令，让团队成员清楚各自职责，整个团队如同烈火军团，充满战斗力，攻克重重难关。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "生活中的你，火象的活力促使你积极进取，ESTJ 的务实态度让你注重实际效果，无论是处理家庭事务还是规划个人发展，你都能雷厉风行，像一团炽热又务实的火焰，照亮生活之路。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESTJ"
                    ),

                    Answer (
                        content = "身为火象的 ESFJ，你那如火的热情让你热衷于与人交往，ESFJ 的友善亲和又使你总能照顾到每个人的感受，在社交场合中，像温暖的阳光，洒向每一个人，营造出和谐融洽的氛围，深受大家喜爱。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "在团队里，你这火象的 ESFJ 是团队的黏合剂，用热情去凝聚人心，凭借 ESFJ 的组织协调能力和对他人情绪的敏锐感知，让团队成员紧密合作，如同火焰将大家汇聚在一起，共同为目标奋斗。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "生活中，你凭借火象的积极乐观去面对一切，ESFJ 的关心他人让你时刻留意身边人的需求，你就像一团充满爱意的火焰，用自己的热情和关怀，为生活增添许多温暖色彩。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESFJ"
                    ),

                    Answer (
                        content = "你有着火象星座的冒险精神，搭配 ISTP 的冷静机智，面对未知时，像勇敢探索的火苗，敢于尝试新事物，同时又能凭借 ISTP 的应变能力和动手能力，在实践中巧妙应对各种突发情况，收获别样体验。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "在社交场合，你这火象的 ISTP 既有热情外向的一面，又因 ISTP 的理性务实，与人交流时总能带来实际又有趣的话题，像灵动的火花，在互动中碰撞出不一样的精彩，让人印象深刻。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "遇到挑战时，你这火象的 ISTP 会燃起内心的斗志，运用 ISTP 的分析和解决问题的能力，像火焰突破阻碍般，灵活地找到应对之法，在挑战中展现出独特的果敢与智慧。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISTP"
                    ),

                    Answer (
                        content = "作为火象的 ISFP，你那如火的活力让你对生活充满热爱，ISFP 的细腻情感又使你善于发现生活中的美好，在日常中，像一束温柔的火焰，用独特的审美和对生活的热情，创造出一个个充满诗意的瞬间。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "在团队中，你这火象的 ISFP 虽不张扬但独具魅力，火象的热情让你积极参与，ISFP 的艺术气质和体贴他人，能为团队带来别样的氛围，宛如温暖又浪漫的烛光，给团队增添温馨色彩。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "生活里，你凭借火象的积极心态去感受世界，ISFP 的注重内心感受使你遵循自己的内心去生活，你就像一团自由而美好的小火苗，在生活的舞台上绽放属于自己的光彩。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ISFP"
                    ),

                    Answer (
                        content = "你身上兼具火象星座的激情和 ESTP 的大胆冒险，面对生活就像一团燃烧的烈火，总是迫不及待地去探索新领域，凭借 ESTP 的果敢和对刺激的追求，在各种挑战中如鱼得水，书写精彩刺激的人生篇章。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "在社交场合中，你这火象的 ESTP 是绝对的焦点，火象的热情让你活力四射，ESTP 的风趣幽默和善于交际，能让你轻松融入任何群体，像一把热烈的火炬，照亮并带动整个氛围，让人开怀大笑。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这火象的 ESTP 会毫不犹豫地燃起斗志，运用 ESTP 的应变能力和实践经验，像火焰冲破阴霾般，迅速找到解决办法，继续在充满冒险的道路上勇往直前。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESTP"
                    ),

                    Answer (
                        content = "身为火象的 ESFP，你那如火的热情让你时刻以积极的态度面对生活，ESFP 的活泼开朗又使你成为众人眼中的开心果，在生活的舞台上，像灿烂的阳光，用你的乐观和活力，给周围带来无尽的欢乐与活力。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "在团队里，你这火象的 ESFP 是团队的活力源泉，用热情去感染每一个人，凭借 ESFP 的表演天赋和社交能力，总能让团队氛围轻松愉快，如同燃烧的火焰，让大家在欢快中共同前进。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "生活中，你凭借火象的热爱生活去拥抱每一刻，ESFP 的享受当下让你充分体验生活的美好，你就像一团永不熄灭的快乐火焰，把快乐传递给身边的每一个人。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ESFP"
                    ),

                    Answer (
                        content = "你有着火象星座的热情，又有着 INFJ 的深邃洞察力，面对世界时，像一团温暖而神秘的火焰，既能用热情去探索，又凭借 INFJ 的直觉和对人性的理解，在人际交往和追求理想中，建立起深刻且有意义的联系。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这火象的 INFJ 宛如心灵的灯塔，用热情去关心队友，以 INFJ 的远见卓识和对他人情感的敏锐感知，为团队指引方向，协调关系，如同温暖的火光，照亮团队前行的路。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借火象的积极心态去面对生活，INFJ 的内省和对生活意义的追寻，让你在平凡中探寻不凡，像一团蕴含深意的火焰，燃烧着自己的独特人生。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INFJ"
                    ),

                    Answer (
                        content = "作为火象的 INFP，你那如火的活力激发着你内心的理想主义，INFP 的浪漫情怀又让你眼中的世界充满诗意，在生活中，像一束充满希望的火焰，怀揣着美好的憧憬，用爱与热情去追逐心中的梦想，点亮生活的每一处角落。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = "在社交场合，你这火象的 INFP 既有热情的一面，又因 INFP 的敏感细腻，与人相处时总能营造出温暖而真挚的氛围，像柔和的烛光，用自己的真诚去打动他人，建立起深厚的情谊。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = "面对困难时，你这火象的 INFP 会燃起内心的勇气，运用 INFP 的想象力和对内心信念的坚守，像火焰冲破黑暗般，在困境中寻找希望，继续朝着充满爱与美好的方向前行。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "INFP"
                    ),


                    Answer (
                        content = "你身上兼具火象星座的热情和 ENFJ 的感染力，面对众人时，像一团熊熊燃烧的烈火，用自己的热情去激励他人，凭借 ENFJ 的领导魅力和对他人需求的关注，能够凝聚人心，带领大家共同朝着美好的目标迈进。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENFJ"
                    ),
                    Answer (
                        content = "在团队中，你这火象的 ENFJ 是当之无愧的核心人物，火象的活力让你充满干劲，ENFJ 的善于沟通和协调，能让团队成员紧密合作，整个团队如同烈火般充满力量，攻克一个个难题，创造辉煌成就。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENFJ"
                    ),
                    Answer (
                        content = "生活中的你，火象的积极心态促使你去关心身边的一切，ENFJ 的奉献精神让你总是为他人着想，你就像一团无私奉献的火焰，用自己的光和热，为生活带来无尽的温暖与美好。",
                        zodiacGroup = "Fire",
                        mbtiGroup = "ENFJ"
                    ),

//---------------------------------------------------------------------------------------------------------------------------
                    Answer (
                        content = "Earth 星座赋予你沉稳内敛的气质，搭配 INTJ 的睿智理性，让你做事时宛如大地般坚实可靠。面对复杂任务，你会不慌不忙，按部就班地依据严谨规划去执行，用冷静且深刻的思考去攻克一个个难题，像大地承载万物般稳稳收获成果。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "在工作环境中，你这 Earth 星座的 INTJ 是团队的定海神针，Earth 的务实让你注重实际成效，INTJ 的善于布局使你能提前规划好每一个步骤，有条不紊地推动项目进展，成为大家信赖依靠的核心力量。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "生活里，你秉持 Earth 星座的踏实态度，不过分追求虚华，INTJ 的冷静判断助力你做出合理决策，对待大小事务都深思熟虑，就像大地默默守护着生活的每一处，让日子过得平稳有序，充满质感。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INTJ"
                    ),


                    Answer (
                        content = "身为 Earth 星座的 INTP，你既有土象的沉稳，又有着 INTP 的好奇探索之心。你会像大地蕴藏宝藏般，在内心深处积累着对世界的诸多疑问，然后凭借自己的理性思维和逻辑分析，冷静地挖掘答案，让知识在沉稳中不断积累拓展。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "在社交互动中，你带着 Earth 星座的质朴，结合 INTP 的理性客观，与人交流时虽话不多，但每一句都如深埋地下的玉石般珍贵，常能抛出深刻独到的见解，引发他人思考，像大地给人踏实又充满智慧的感觉。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "面对生活中的挑战，你这 Earth 星座的 INTP 不会慌乱，而是像大地经受风雨依然稳固那样，运用 INTP 的善于思考和应变能力，从不同角度剖析问题，沉稳地找到解决之道，稳步前行。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INTP"
                    ),

                    Answer (
                        content = "你身上兼具 Earth 星座的脚踏实地和 ENTJ 的强大领导力，面对目标就像大地承载高楼大厦般，有着坚实的基础去支撑宏伟蓝图。凭借果断决策和出色的组织能力，你能有条不紊地带领众人朝着目标迈进，打造出令人瞩目的成就。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Earth 星座的 ENTJ 是团队的坚实脊梁，Earth 的务实让你重视实际执行，ENTJ 的战略眼光使你能规划出清晰路径，用沉稳又有力的方式安排工作，激励队员，让整个团队如在坚实大地上稳步奔跑，攻克重重难关。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "生活中的你，Earth 星座的稳重促使你做事靠谱，ENTJ 的理性把控保障行动有序，无论是处理日常事务还是规划长远发展，你都能把控全局，像大地般给人可靠、安心的感觉，让生活井井有条。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENTJ"
                    ),


                    Answer (
                        content = "作为 Earth 星座的 ENTP，你有着土象的沉稳，又不失 ENTP 的灵动与机智。在面对新情况时，你像大地般有着稳定的根基，同时能凭借 ENTP 的创新思维和敏捷反应，从看似平常的事物中发现新奇角度，为生活和工作带来别样的活力与创意。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "在社交场合，你凭借 Earth 星座的真诚质朴，结合 ENTP 的幽默风趣，仿佛一片承载着欢声笑语的坚实土地，轻松融入群体，与人交流时总能巧妙地用独特观点和诙谐话语，让氛围轻松愉快，成为大家喜爱交往的对象。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这 Earth 星座的 ENTP 会像大地一样沉稳应对，运用 ENTP 的善于应变和多角度思考能力，像挖掘地下通道般巧妙地绕过阻碍，继续朝着充满希望的方向前行，展现出沉稳又灵活的智慧。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENTP"
                    ),

                    Answer (
                        content = "你有着 Earth 星座的踏实靠谱，再加上 ISTJ 的严谨负责，面对任务就像大地般可靠，每一个环节都严格遵循既定规则和流程，凭借细致和坚持，确保工作高质量完成，如同大地用稳固支撑起生活的秩序。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "在团队里，你这 Earth 星座的 ISTJ 是让人安心的存在，Earth 的务实让你默默做好分内事，ISTJ 的守纪律和注重细节，能保证团队工作不出差错，如同大地守护着每一个角落，为团队的稳定运作保驾护航。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "生活中，Earth 星座的你以实际行动对待生活，ISTJ 的条理分明使你能把生活安排得井井有条，无论是打理家务还是规划个人事务，你都能稳稳当当，像大地般给身边人带来踏实感和安全感。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISTJ"
                    ),

                    Answer (
                        content = "身为 Earth 星座的 ISFJ，你既有土象的温和质朴，又有着 ISFJ 的细腻体贴。在与人相处时，像大地般默默付出，用温柔的关怀和耐心的倾听，关注他人的需求，给身边人带来如大地般温暖又踏实的感觉，让人倍感安心。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "在团队中，你这 Earth 星座的 ISFJ 虽低调但不可或缺，Earth 的踏实让你认真完成各项任务，ISFJ 的善于照顾他人，能把团队氛围营造得温馨和谐，宛如大地承载着万物生长，为团队注入温暖与关怀。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借 Earth 星座的务实去经营生活，ISFJ 的关爱他人使你总是把身边人的感受放在首位，你就像一片充满爱意的大地，用自己的行动，让生活充满浓浓的人情味和踏实感。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISFJ"
                    ),

                    Answer (
                        content = "你身上融合了 Earth 星座的脚踏实地和 ESTJ 的果断干练，面对目标时，像大地般有着坚实的根基去支撑行动，凭借强大的执行力和对秩序的严格维护，高效组织资源，确保计划按部就班地推进，收获实实在在的成果。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Earth 星座的 ESTJ 是强有力的领导者，Earth 的务实让你重视实际效果，ESTJ 的严谨管理和明确指令，能让团队成员清楚各自职责，整个团队如同在坚实大地上稳步前行的队伍，充满战斗力，攻克一个个难关。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "生活中的你，Earth 星座的稳重促使你积极进取，ESTJ 的务实态度让你注重实际成效，无论是打理家庭事务还是规划个人发展，你都能雷厉风行，像大地般给人可靠、务实的印象，让生活稳步向前。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESTJ"
                    ),


                    Answer (
                        content = "作为 Earth 星座的 ESFJ，你那土象的沉稳让你在与人交往中给人可靠的感觉，ESFJ 的友善亲和又使你总能照顾到每个人的情绪和需求，在社交场合中，像大地般包容万物，营造出和谐融洽的氛围，深受大家喜爱和信赖。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "在团队里，你这 Earth 星座的 ESFJ 是团队的黏合剂，Earth 的务实让你积极为团队做事，凭借 ESFJ 的组织协调能力和对他人感受的敏锐感知，让团队成员紧密合作，如同大地将大家汇聚在一起，共同为目标奋斗，充满凝聚力。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "生活中，你凭借 Earth 星座的踏实去面对一切，ESFJ 的关心他人让你时刻留意身边人的生活，你就像一片充满爱意的大地，用自己的热情和关怀，为生活增添许多温暖与踏实的色彩。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESFJ"
                    ),

                    Answer (
                        content = "你有着 Earth 星座的沉稳，搭配 ISTP 的冷静机智，面对未知时，像大地般有着稳定的心态，敢于尝试新事物，同时又能凭借 ISTP 的应变能力和动手能力，在实践中巧妙应对各种突发情况，如同大地承载变化，收获别样体验。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "在社交场合，你这 Earth 星座的 ISTP 既有沉稳内敛的一面，又因 ISTP 的理性务实，与人交流时总能带来实际又有趣的话题，像大地蕴含丰富宝藏般，在互动中展现出别样的精彩，让人印象深刻。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "遇到挑战时，你这 Earth 星座的 ISTP 会像大地一样沉稳应对，运用 ISTP 的分析和解决问题的能力，像挖掘地下宝藏般，灵活地找到应对之法，在挑战中展现出独特的沉稳与智慧。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISTP"
                    ),

                    Answer (
                        content = "身为 Earth 星座的 ISFP，你既有土象的质朴温和，又有着 ISFP 的细腻情感和艺术气质。在生活中，像大地滋养万物般，用自己独特的审美和对生活的热爱，从平凡中发现美好，创造出一个个充满诗意与温暖的瞬间。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "在团队中，你这 Earth 星座的 ISFP 虽不张扬但独具魅力，Earth 的踏实让你积极参与，ISFP 的体贴他人和艺术感染力，能为团队带来别样的氛围，宛如大地承载着多彩的花朵，给团队增添温馨与浪漫的色彩。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "生活里，你凭借 Earth 星座的务实去感受世界，ISFP 的注重内心感受使你遵循自己的内心去生活，你就像一片自由而美好的大地，在生活的舞台上绽放属于自己的光彩，给身边人带来温暖与美好。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ISFP"
                    ),

                    Answer (
                        content = "你身上兼具 Earth 星座的踏实和 ESTP 的大胆冒险，面对生活就像大地般有着坚实的基础去支撑探索，凭借 ESTP 的果敢和对刺激的追求，在各种挑战中既能保持沉稳，又能如鱼得水，书写精彩刺激又靠谱的人生篇章。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "在社交场合中，你这 Earth 星座的 ESTP 是充满魅力的存在，Earth 的沉稳让你给人可靠感觉，ESTP 的风趣幽默和善于交际，能让你轻松融入任何群体，像大地承载着欢乐，照亮并带动整个氛围，让人开怀大笑。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这 Earth 星座的 ESTP 会像大地一样沉稳应对，运用 ESTP 的应变能力和实践经验，像挖掘地下通道般，迅速找到解决办法，继续在充满冒险的道路上稳步前行，展现出沉稳又勇敢的一面。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESTP"
                    ),


                    Answer (
                        content = "作为 Earth 星座的 ESFP，你那土象的沉稳让你在生活中有着可靠的一面，ESFP 的活泼开朗又使你时刻以积极的态度面对生活，在生活的舞台上，像大地承载阳光般，用你的乐观和活力，给周围带来无尽的欢乐与踏实感。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "在团队里，你这 Earth 星座的 ESFP 是团队的活力源泉，Earth 的务实让你积极参与团队事务，凭借 ESFP 的表演天赋和社交能力，总能让团队氛围轻松愉快，如同大地滋养着生机，让大家在欢快中共同前进，充满活力。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "生活中，你凭借 Earth 星座的踏实去拥抱每一刻，ESFP 的享受当下让你充分体验生活的美好，你就像一片永不熄灭的快乐大地，把快乐传递给身边的每一个人，让生活充满温暖与活力。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESFP"
                    ),

                    Answer (
                        content = "你有着 Earth 星座的沉稳内敛，又有着 INFJ 的深邃洞察力，面对世界时，像大地般默默承载着对生活的感悟，既能用沉稳的心态去探索，又凭借 INFJ 的直觉和对人性的理解，在人际交往和追求理想中，建立起深刻且可靠的联系。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Earth 星座的 INFJ 宛如心灵的基石，用沉稳去关心队友，以 INFJ 的远见卓识和对他人情感的敏锐感知，为团队指引方向，协调关系，如同大地承载着团队的前行，照亮团队发展的路。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借 Earth 星座的踏实态度去面对生活，INFJ 的内省和对生活意义的追寻，让你在平凡中探寻不凡，像大地般蕴含着无尽深意，燃烧着自己独特而靠谱的人生。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INFJ"
                    ),

                    Answer (
                        content = "身为 Earth 星座的 INFP，你那土象的质朴温和激发着你内心的理想主义，INFP 的浪漫情怀又让你眼中的世界充满诗意，在生活中，像大地滋养希望般，怀揣着美好的憧憬，用爱与沉稳去追逐心中的梦想，点亮生活的每一处角落。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = "在社交场合，你这 Earth 星座的 INFP 既有沉稳的一面，又因 INFP 的敏感细腻，与人相处时总能营造出温暖而真挚的氛围，像大地承载着情谊，用自己的真诚去打动他人，建立起深厚的情谊。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = "面对困难时，你这 Earth 星座的 INFP 会像大地一样沉稳应对，运用 INFP 的想象力和对内心信念的坚守，像从大地汲取力量般，在困境中寻找希望，继续朝着充满爱与美好的方向稳步前行。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "INFP"
                    ),

                    Answer (
                        content = "你身上兼具 Earth 星座的踏实和 ENFJ 的感染力，面对众人时，像大地般有着坚实的基础去传递热情，用自己的沉稳去激励他人，凭借 ENFJ 的领导魅力和对他人需求的关注，能够凝聚人心，带领大家共同朝着美好的目标稳步迈进。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENFJ"
                    ),
                    Answer (
                        content = "在团队中，你这 Earth 星座的 ENFJ 是当之无愧的核心人物，Earth 的务实让你充满干劲，ENFJ 的善于沟通和协调，能让团队成员紧密合作，整个团队如同在坚实大地上蓬勃发展的集体，攻克一个个难题，创造辉煌成就。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENFJ"
                    ),
                    Answer (
                        content = "生活中的你，Earth 星座的稳重促使你去关心身边的一切，ENFJ 的奉献精神让你总是为他人着想，你就像一片无私奉献的大地，用自己的光和热，为生活带来无尽的温暖与踏实的美好。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ENFJ"
                    ),
//---------------------------------------------------------------------------------------------------------------------------
                    Answer (
                        content = "Water 星座赋予你深邃细腻的情感世界，与 INTJ 的理性思维相辅相成。面对问题时，你既能如静谧湖水般深入洞察背后的情感因素，又能用有条理的分析去抽丝剥茧，找到解决之道，如水般柔和却有力量地应对生活种种，让智慧在情感的滋养下绽放。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "在与人相处中，你这 Water 星座的 INTJ 看似内敛冷静，实则内心有着如水般的温情，会默默地关心他人，同时凭借 INTJ 的智慧，为身边的人提供有价值的建议，宛如一湾深邃的湖水，让人在靠近时能感受到宁静与可靠，成为值得信赖的知心伙伴。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "生活里，Water 星座的你情感丰富，INTJ 的特质又让你善于规划和思考未来，你就像一条缓缓流淌的河流，表面平静却蕴含无尽能量，用心经营着自己的生活，朝着心中目标蜿蜒前行，在岁月中留下细腻而深刻的痕迹。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INTJ"
                    ),

                    Answer (
                        content = "身为 Water 星座的 INTP，你那如水般灵动且深邃的内心，激发着你对世界无尽的好奇，驱使你像探索水底奥秘般，不断去思考、分析，用独特的逻辑和创新思维，解开一个个复杂谜题，让知识的涓涓细流汇聚成智慧的海洋，润泽生活。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "在社交场合，你虽有着水象的内敛一面，但 INTP 的理性又让你在交流时能抛出如灵动水珠般新奇的观点，与人碰撞出思维的火花，仿佛潺潺溪流，给周围带来清新且引人深思的氛围，让人领略到你内心世界的丰富与独特。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "面对挑战，你这 Water 星座的 INTP 不会被轻易击退，而是凭借内心如水般的坚韧和善于思考的能力，像水流绕过礁石一样，冷静拆解问题，灵活找到解决路径，在挑战中展现出如水般的柔韧与智慧。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INTP"
                    ),


                    Answer (
                        content = "你身上兼具 Water 星座的情感深度和 ENTJ 的领导力，就像汹涌澎湃却又深沉的大海，在面对复杂局势时，既能凭借强大的气场和果断决策引领众人，又能顾及他人情感，以情动人，带领大家朝着目标奋勇前行，在情感与理智交织中铸就辉煌成就。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Water 星座的 ENTJ 是充满温情的核心，用如水般的细腻去关注队员的情绪，同时以 ENTJ 的战略眼光和高效执行力，有条不紊地安排工作，让整个团队如在浪潮推动下，攻克一个个难关，迈向胜利，既充满力量又饱含情谊。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "生活中的你，Water 星座的情感丰富促使你重视人际关系，ENTJ 的理性判断保障行动的正确方向，无论大事小事，你都能把控全局，像一片包容万物的汪洋，用深沉的爱与智慧照亮生活的每一处角落。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ENTJ"
                    ),

                    Answer (
                        content = "作为 Water 星座的 ENTP，你那如水的灵动与丰富情感，让你对新事物充满无尽兴趣，ENTP 的机智敏捷又使你总能快速发现新奇角度，在各种场合中，像跳跃的水花，抛出不同寻常的想法，给周围带来充满活力又饱含情感韵味的氛围。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "在社交中，你凭借 Water 星座的温柔亲和，结合 ENTP 的幽默风趣，仿佛一泓清泉，轻松地融入不同群体，与大家畅聊各种有趣话题，让氛围变得轻松愉悦，如流水般自然舒畅，大家都能感受到你独特的亲和力与智慧魅力。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这 Water 星座的 ENTP 会唤起内心如水般的韧性和创造力，用 ENTP 的创新思维和善于应变的能力，从多角度去突破困境，如同水流冲破堤坝般，继续闪耀前行，书写精彩故事，让情感在克服困难中更加深沉。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ENTP"
                    ),

                    Answer (
                        content = "你有着 Water 星座的温情细腻，同时 ISTJ 的严谨踏实让你做事有条不紊，面对任务时，像平稳流淌的溪流，一步一个脚印，凭借对规则的严格遵守和认真负责的态度，确保每项工作都能高质量完成，用如水般的坚持与责任守护生活的秩序。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "在团队里，你这 Water 星座的 ISTJ 是可靠的港湾，用如水般的温柔去支持队友，ISTJ 的细心和坚持原则，又能保证团队工作按部就班，避免差错，如同静谧的湖水，守护着团队的稳定运作，给大家带来安心的感觉。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "生活中，Water 星座的温情让你积极对待生活，ISTJ 的条理分明使你能把生活安排得井然有序，无论是家庭琐事还是个人规划，你都能稳稳当当，像一湾清澈的水，给身边人带来舒心与安心，润泽周围的一切。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISTJ"
                    ),

                    Answer (
                        content = "作为 Water 星座的 ISFJ，你既有水般的温柔体贴，又有着 ISFJ 的细腻关怀，在与人相处时，像涓涓细流，默默地关心他人，用细致入微的呵护，给身边的人带来如春雨般的滋润，让人倍感温馨，在情感的交流中传递着浓浓的爱意。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "在团队中，你这 Water 星座的 ISFJ 虽低调但不可或缺，水象的温情让你积极承担任务，ISFJ 的耐心和专注，能把每项工作都处理得妥妥当当，宛如一泓宁静的水塘，照亮团队中每一个需要的角落，用默默的付出营造和谐氛围。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借 Water 星座的深情去拥抱生活，ISFJ 的善于照顾他人使你总是把身边人的需求放在首位，你就像一条流淌着爱的小溪，用自己的行动，让生活充满浓浓的人情味，润泽每一个平凡日子。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISFJ"
                    ),

                    Answer (
                        content = "你身上融合了 Water 星座的情感细腻和 ESTJ 的果断干练，面对目标时，像奔腾不息的河流，勇往直前，凭借强大的执行力和对秩序的维护，能够高效地组织资源，确保计划顺利推进，同时也不忘顾及身边人的感受，在达成预期成果中融入情感温度。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Water 星座的 ESTJ 是既有力量又有温情的领导者，用如水般的体贴去激励队员，以 ESTJ 的严谨管理和明确指令，让团队成员清楚各自职责，整个团队如同在浪潮助力下，攻克重重难关，充满战斗力又饱含情谊。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "生活中的你，Water 星座的情感丰富促使你积极进取，ESTJ 的务实态度让你注重实际效果，无论是处理家庭事务还是规划个人发展，你都能雷厉风行，像一条充满活力又不失温情的河流，照亮生活之路，润泽身边的一切。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESTJ"
                    ),

                    Answer (
                        content = "身为 Water 星座的 ESFJ，你那如水的温柔让你热衷于与人交往，ESFJ 的友善亲和又使你总能照顾到每个人的感受，在社交场合中，像一湾温暖的湖水，洒向每一个人，营造出和谐融洽的氛围，深受大家喜爱，让大家在情感的交融中感受生活的美好。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "在团队里，你这 Water 星座的 ESFJ 是团队的黏合剂，用如水般的细腻去凝聚人心，凭借 ESFJ 的组织协调能力和对他人情绪的敏锐感知，让团队成员紧密合作，如同水流汇聚在一起，共同为目标奋斗，充满凝聚力与情感共鸣。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "生活中，你凭借 Water 星座的深情去面对一切，ESFJ 的关心他人让你时刻留意身边人的需求，你就像一片充满爱意的水域，用自己的热情和关怀，为生活增添许多温暖色彩，让情感在日常中不断流淌传递。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESFJ"
                    ),

                    Answer (
                        content = "你有着 Water 星座的敏感细腻，搭配 ISTP 的冷静机智，面对未知时，像灵动的水滴，敢于尝试新事物，同时又能凭借 ISTP 的应变能力和动手能力，在实践中巧妙应对各种突发情况，如同水流适应各种地形，收获别样体验，让情感在探索中丰富起来。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "在社交场合，你这 Water 星座的 ISTP 既有内敛含蓄的一面，又因 ISTP 的理性务实，与人交流时总能带来实际又有趣的话题，像闪烁的水珠，在互动中碰撞出不一样的精彩，让人印象深刻，展现出你如水般的独特韵味。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "遇到挑战时，你这 Water 星座的 ISTP 会唤起内心如水般的坚韧和冷静，运用 ISTP 的分析和解决问题的能力，像水流冲破阻碍般，灵活地找到应对之法，在挑战中展现出如水般的柔韧与智慧，让情感在应对困难中沉淀升华。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISTP"
                    ),

                    Answer (
                        content = "作为 Water 星座的 ISFP，你那如水的灵动让你对生活充满热爱，ISFP 的细腻情感又使你善于发现生活中的美好，在日常中，像一束柔和的水光，用独特的审美和对生活的热情，创造出一个个充满诗意的瞬间，让情感在美好的体验中流淌蔓延。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "在团队中，你这 Water 星座的 ISFP 虽不张扬但独具魅力，水象的温情让你积极参与，ISFP 的艺术气质和体贴他人，能为团队带来别样的氛围，宛如一泓静谧而浪漫的水塘，给团队增添温馨色彩，让大家在情感的滋养中共同成长。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "生活里，你凭借 Water 星座的深情去感受世界，ISFP 的注重内心感受使你遵循自己的内心去生活，你就像一条自由而美好的水流，在生活的舞台上绽放属于自己的光彩，让情感在自己的小世界里静静流淌，熠熠生辉。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ISFP"
                    ),

                    Answer (
                        content = "你身上兼具 Water 星座的情感深度和 ESTP 的大胆冒险，面对生活就像汹涌澎湃的海浪，总是迫不及待地去探索新领域，凭借 ESTP 的果敢和对刺激的追求，在各种挑战中如鱼得水，同时又不失水般的细腻情感，书写精彩刺激又饱含深情的人生篇章。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "在社交场合中，你这 Water 星座的 ESTP 是充满魅力的焦点，水象的温情让你活力四射，ESTP 的风趣幽默和善于交际，能让你轻松融入任何群体，像一片波光粼粼的水面，照亮并带动整个氛围，让人开怀大笑，在欢乐中传递情感温度。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这 Water 星座的 ESTP 会毫不犹豫地唤起内心如水般的韧性，运用 ESTP 的应变能力和实践经验，像水流冲破阴霾般，迅速找到解决办法，继续在充满冒险的道路上勇往直前，让情感在克服困难中更加深沉坚定。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESTP"
                    ),

                    Answer (
                        content = "身为 Water 星座的 ESFP，你那如水的温柔让你时刻以积极的态度面对生活，ESFP 的活泼开朗又使你成为众人眼中的开心果，在生活的舞台上，像一泓欢快流淌的清泉，用你的乐观和活力，给周围带来无尽的欢乐与滋润，让情感在欢乐氛围中传递扩散。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "在团队里，你这 Water 星座的 ESFP 是团队的活力源泉，用如水般的热情去感染每一个人，凭借 ESFP 的表演天赋和社交能力，总能让团队氛围轻松愉快，如同流动的溪水，让大家在欢快中共同前进，充满活力与情感交流，让工作也变得富有情味。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "生活中，你凭借 Water 星座的深情去拥抱每一刻，ESFP 的享受当下让你充分体验生活的美好，你就像一片永不干涸的快乐水域，把快乐传递给身边的每一个人，让生活充满温暖与情感的润泽。",
                        zodiacGroup = "Water",
                        mbtiGroup = "ESFP"
                    ),

                    Answer (
                        content = "你有着 Water 星座的深邃情感，又有着 INFJ 的深邃洞察力，面对世界时，像一片幽深沉静的湖水，既能用情感去体悟，又凭借 INFJ 的直觉和对人性的理解，在人际交往和追求理想中，建立起深刻且饱含情感的联系，让心灵在情感的海洋中相互交融。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Water 星座的 INFJ 宛如情感的灯塔，用如水般的温柔去关心队友，以 INFJ 的远见卓识和对他人情感的敏锐感知，为团队指引方向，协调关系，如同温暖的水光，照亮团队前行的路，让团队在情感的凝聚中不断进步。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借 Water 星座的深情去面对生活，INFJ 的内省和对生活意义的追寻，让你在平凡中探寻不凡，像一湾蕴含深意的水域，燃烧着自己独特而饱含情感的人生，让生活处处流淌着心灵的触动。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INFJ"
                    ),

                    Answer (
                        content = "作为 Water 星座的 INFP，你那如水的细腻激发着你内心的理想主义，INFP 的浪漫情怀又让你眼中的世界充满诗意，在生活中，像一泓流淌着希望的清泉，怀揣着美好的憧憬，用爱与深情去追逐心中的梦想，点亮生活的每一处角落，让情感在梦想的浇灌下蓬勃生长。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = "在社交场合，你这 Water 星座的 INFP 既有温柔的一面，又因 INFP 的敏感细腻，与人相处时总能营造出温暖而真挚的氛围，像柔和的水波，用自己的真诚去打动他人，建立起深厚的情谊，让情感在人际交往中静静流淌、沉淀。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = "面对困难时，你这 Water 星座的 INFP 会唤起内心如水般的勇气和坚韧，运用 INFP 的想象力和对内心信念的坚守，像水流冲破黑暗般，在困境中寻找希望，继续朝着充满爱与美好的方向前行，让情感在克服困难中愈发深沉坚定。",
                        zodiacGroup = "Water",
                        mbtiGroup = "INFP"
                    ),


//---------------------------------------------------------------------------------------------
                    Answer (
                        content = "Air 星座赋予你灵动的思维和开阔的视野，与 INTJ 的深邃思考相融合，让你宛如一阵清新又有力的风，能在知识的天空中自由翱翔。凭借理性的分析和创新的想法，你可以吹散迷雾，探寻真理，在思想的领域里无拘无束，引领智慧的风向。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "在团队交流中，你这 Air 星座的 INTJ 如同清新的空气，带来不一样的视角和深刻见解。同时又以 INTJ 的严谨逻辑，有条理地阐述观点，引导大家打破思维局限，共同探索更优方案，推动团队在创新的气流中不断进步。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INTJ"
                    ),
                    Answer (
                        content = "生活里，Air 星座的你对新事物充满好奇，INTJ 的特质让你能将好奇转化为深度探索的动力。就像风穿梭在各个角落一样，你不断在不同领域汲取养分，用智慧去充实自己的生活，书写独特篇章，在自由的风中追逐思想的星光。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INTJ"
                    ),

                    Answer (
                        content = "身为 Air 星座的 INTP，你那如风的活力激发着你对世间万物的好奇，驱使你像风拂过大地般，不断去探索、思考。用独特的逻辑和创新思维，你能解开一个个复杂谜题，让知识的种子随风飘散，在不同的心灵中生根发芽，掀起思维的微风。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "在社交场合，你虽有着风象的热情外向一面，但 INTP 的理性又让你保持独立思考。与人交流时，常能像灵动的风带来新奇的气息，抛出新奇观点，点燃大家思维的火花，在互动的气流中创造出活跃的思想氛围。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INTP"
                    ),
                    Answer (
                        content = "面对挑战，你这 Air 星座的 INTP 不会畏惧，而是像风一样勇往直前。运用自己擅长的分析能力，冷静拆解问题，凭借灵活的思维，找到解决路径，在挑战的狂风中展现智慧的灵动与坚韧。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INTP"
                    ),

                    Answer (
                        content = "你身上兼具 Air 星座的果敢和 ENTJ 的领导力，就像强劲的旋风，在面对复杂局势时，果断决策，凭借强大的气场和组织能力，引领众人朝着目标奋勇前行。你能掌控风向，带领团队在成功的航道上乘风破浪，掀起变革的风暴。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Air 星座的 ENTJ 是当之无愧的核心，用热情去鼓舞士气，以 ENTJ 的战略眼光和高效执行力，有条不紊地安排工作。整个团队如同在你的风力推动下，如翱翔天际的雄鹰，攻克一个个难关，迈向胜利的高空。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ENTJ"
                    ),
                    Answer (
                        content = "生活中的你，Air 星座的冲劲促使你不断追求更高目标，ENTJ 的理性判断保障行动的正确方向。无论大事小事，你都能把控全局，像一阵指挥若定的清风，有条不紊地梳理生活的脉络，让一切顺遂心意。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ENTJ"
                    ),

                    Answer (
                        content = "身为 Air 星座的 ENTP，你那如风的热情让你对新事物充满无尽兴趣，ENTP 的机智敏捷又使你总能快速发现新奇角度。在各种场合中，你像灵动的风，跳跃出不同寻常的想法，给周围带来充满活力的氛围，如同春风吹过，万物复苏般激发创新与欢乐。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "在社交中，你凭借 Air 星座的灵动亲和，结合 ENTP 的幽默风趣，轻易就能成为焦点。像一把热情的火炬，吸引着众人围绕，大家一起在欢声笑语中交流思想，开拓视野，感受你如同清风拂面般的独特魅力，在愉悦的气流中共享智慧的盛宴。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ENTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这 Air 星座的 ENTP 会燃起斗志，用 ENTP 的创新思维和善于应变的能力，从多角度去突破困境。如同风卷残云般吹散困难，继续向着充满阳光的方向前行，在困境的逆风中开辟出希望的风道。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ENTP"
                    ),

                    Answer (
                        content = "你有着 Air 星座的积极活力，同时 ISTJ 的严谨踏实让你做事有条不紊。面对任务时，像稳定吹拂的微风，一步一个脚印，凭借对规则的严格遵守和认真负责的态度，确保每项工作都能高质量完成，在规律的气流中保障生活与工作的稳定运行。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "在团队里，你这 Air 星座的 ISTJ 是可靠的后盾，用热情去支持队友，ISTJ 的细心和坚持原则，又能保证团队工作按部就班，避免差错。如同坚固的防风林，守护着团队的稳定运作，在稳定的气流中为团队遮风挡雨。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISTJ"
                    ),
                    Answer (
                        content = "生活中，Air 星座的热情让你积极对待生活，ISTJ 的条理分明使你能把生活安排得井然有序。无论是家庭琐事还是个人规划，你都能稳稳当当，像一阵温和而有序的风，给身边人带来安心与舒适，在平静的风息中享受生活的美好。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISTJ"
                    ),

                    Answer (
                        content = "作为 Air 星座的 ISFJ，你既有风般的热情，又有着 ISFJ 的温柔体贴。在与人相处时，像轻柔的微风，默默地关心他人，用细致入微的关怀，给身边的人带来如春日暖阳般的温暖，让人倍感温馨，在柔和的风语中传递关爱与情谊。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "在团队中，你这 Air 星座的 ISFJ 虽低调但不可或缺，风象的活力让你积极承担任务，ISFJ 的耐心和专注，能把每项工作都处理得妥妥当当。宛如和缓的春风，吹遍团队中每一个需要的角落，在默默的奉献中风抚人心，促进团队和谐。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借 Air 星座的积极心态去拥抱生活，ISFJ 的善于照顾他人使你总是把身边人的需求放在首位。你就像一缕贴心的微风，用爱与关怀，让生活充满浓浓的人情味，在温暖的风拂中编织生活的美好画卷。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISFJ"
                    ),

                    Answer (
                        content = "你身上融合了 Air 星座的冲劲和 ESTJ 的果断干练，面对目标时，像迅猛的疾风，勇往直前，凭借强大的执行力和对秩序的维护，能够高效地组织资源，确保计划顺利推进，达成预期成果，在强劲的风力下推动目标的达成。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Air 星座的 ESTJ 是强有力的领导者，用热情去激励队员，以 ESTJ 的严谨管理和明确指令，让团队成员清楚各自职责。整个团队如同在你的风势引领下，如离弦之箭，攻克重重难关，充满战斗力地冲向胜利的彼岸，在有力的气流中凝聚团队力量。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESTJ"
                    ),
                    Answer (
                        content = "生活中的你，Air 星座的活力促使你积极进取，ESTJ 的务实态度让你注重实际效果。无论是处理家庭事务还是规划个人发展，你都能雷厉风行，像一阵炽热又务实的风，照亮生活之路，在高效的风动中优化生活品质。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESTJ"
                    ),

                    Answer (
                        content = "身为 Air 星座的 ESFJ，你那如风的热情让你热衷于与人交往，ESFJ 的友善亲和又使你总能照顾到每个人的感受。在社交场合中，像温暖的春风，洒向每一个人，营造出和谐融洽的氛围，深受大家喜爱，在欢快的风扬中促进人际交往的融洽。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "在团队里，你这 Air 星座的 ESFJ 是团队的黏合剂，用热情去凝聚人心，凭借 ESFJ 的组织协调能力和对他人情绪的敏锐感知，让团队成员紧密合作。如同和风将大家汇聚在一起，共同为目标奋斗，在凝聚的风团中提升团队凝聚力。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESFJ"
                    ),
                    Answer (
                        content = "生活中，你凭借 Air 星座的积极乐观去面对一切，ESFJ 的关心他人让你时刻留意身边人的需求。你就像一团充满爱意的风，用自己的热情和关怀，为生活增添许多温暖色彩，在关爱的风拂中点亮生活的温馨角落。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESFJ"
                    ),

                    Answer (
                        content = "你有着 Air 星座的冒险精神，搭配 ISTP 的冷静机智，面对未知时，像勇敢探索的信风，敢于尝试新事物，同时又能凭借 ISTP 的应变能力和动手能力，在实践中巧妙应对各种突发情况，收获别样体验，在冒险的风旅中拓展自我。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "在社交场合，你这 Air 星座的 ISTP 既有热情外向的一面，又因 ISTP 的理性务实，与人交流时总能带来实际又有趣的话题。像灵动的风带来新奇资讯，在互动中碰撞出不一样的精彩，让人印象深刻，在风趣的风谈中丰富社交生活。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISTP"
                    ),
                    Answer (
                        content = "遇到挑战时，你这 Air 星座的 ISTP 会燃起内心的斗志，运用 ISTP 的分析和解决问题的能力，像风突破阻碍般，灵活地找到应对之法，在挑战的风口展现出独特的果敢与智慧，在困境的风旋中找到出路。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISTP"
                    ),

                    Answer (
                        content = "作为 Air 星座的 ISFP，你那如风的活力让你对生活充满热爱，ISFP 的细腻情感又使你善于发现生活中的美好。在日常中，像一束灵动的风影，用独特的审美和对生活的热情，创造出一个个充满诗意的瞬间，在艺术的风韵中感受生活的魅力。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "在团队中，你这 Air 星座的 ISFP 虽不张扬但独具魅力，风象的热情让你积极参与，ISFP 的艺术气质和体贴他人，能为团队带来别样的氛围。宛如轻柔的艺术之风，给团队增添温馨色彩，在创意的风拂中激发团队灵感。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISFP"
                    ),
                    Answer (
                        content = "生活里，你凭借 Air 星座的积极心态去感受世界，ISFP 的注重内心感受使你遵循自己的内心去生活。你就像一缕自由而美好的风，在生活的舞台上绽放属于自己的光彩，在自在的风舞中追寻内心的宁静与快乐。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ISFP"
                    ),

                    Answer (
                        content = "你身上兼具 Air 星座的激情和 ESTP 的大胆冒险，面对生活就像一团燃烧的热风，总是迫不及待地去探索新领域，凭借 ESTP 的果敢和对刺激的追求，在各种挑战中如鱼得水，书写精彩刺激的人生篇章，在冒险的热风潮中尽情挥洒热情。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "在社交场合中，你这 Air 星座的 ESTP 是绝对的焦点，风象的热情让你活力四射，ESTP 的风趣幽默和善于交际，能让你轻松融入任何群体。像一把热烈的风火轮，照亮并带动整个氛围，让人开怀大笑，在热闹的风涌中成为社交中心。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESTP"
                    ),
                    Answer (
                        content = "遇到困难时，你这 Air 星座的 ESTP 会毫不犹豫地燃起斗志，运用 ESTP 的应变能力和实践经验，像风冲破阴霾般，迅速找到解决办法，继续在充满冒险的道路上勇往直前，在困境的风破中砥砺前行。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESTP"
                    ),

                    Answer (
                        content = "身为 Air 星座的 ESFP，你那如风的热情让你时刻以积极的态度面对生活，ESFP 的活泼开朗又使你成为众人眼中的开心果。在生活的舞台上，像灿烂的阳光风，用你的乐观和活力，给周围带来无尽的欢乐与活力，在欢快的风跃中传递快乐能量。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "在团队里，你这 Air 星座的 ESFP 是团队的活力源泉，用热情去感染每一个人，凭借 ESFP 的表演天赋和社交能力，总能让团队氛围轻松愉快。如同欢快的旋风，让大家在欢快中共同前进，在愉悦的风旋中提升团队士气。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESFP"
                    ),
                    Answer (
                        content = "生活中，你凭借 Air 星座的热爱生活去拥抱每一刻，ESFP 的享受当下让你充分体验生活的美好。你就像一团永不熄灭的快乐风，把快乐传递给身边的每一个人，在幸福的风拂中享受生活的每一个美好瞬间。",
                        zodiacGroup = "Air",
                        mbtiGroup = "ESFP"
                    ),

                    Answer (
                        content = "你有着 Air 星座的热情，又有着 INFJ 的深邃洞察力，面对世界时，像一团温暖而神秘的季风，既能用热情去探索，又凭借 INFJ 的直觉和对人性的理解，在人际交往和追求理想中，建立起深刻且有意义的联系，在心灵的风语中感悟人生真谛。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "在团队协作中，你这 Air 星座的 INFJ 宛如心灵的灯塔，用热情去关心队友，以 INFJ 的远见卓识和对他人情感的敏锐感知，为团队指引方向，协调关系。如同明亮的信风，照亮团队前行的路，在智慧的风引中引领团队成长。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INFJ"
                    ),
                    Answer (
                        content = "生活里，你凭借 Air 星座的积极心态去面对生活，INFJ 的内省和对生活意义的追寻，让你在平凡中探寻不凡。像一团蕴含深意的风，燃烧着自己的独特人生，在深邃的风思中追寻生命的意义。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INFJ"
                    ),

                    Answer (
                        content = "作为 Air 星座的 INFP，你那如风的活力激发着你内心的理想主义，INFP 的浪漫情怀又让你眼中的世界充满诗意。在生活中，像一束充满希望的风信子，怀揣着美好的憧憬，用爱与热情去追逐心中的梦想，点亮生活的每一处角落，在梦想的风追中绽放希望之光。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = "在社交场合，你这 Air 星座的 INFP 既有热情的一面，又因 INFP 的敏感细腻，与人相处时总能营造出温暖而真挚的氛围。像柔和的春风，用自己的真诚去打动他人，建立起深厚的情谊，在情感的风暖中缔结真挚友谊。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INFP"
                    ),
                    Answer (
                        content = " 面对困难时，你这 Air 星座的 INFP 会燃起内心的勇气，运用 INFP 的想象力和对内心信念的坚守，像风。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INFP"
                    ),






                    Answer(content = "你早已做出选择，请遵循内心", zodiacGroup = "Water", mbtiGroup = "INTJ"),
                    Answer(content = "听从内心，别被外界干扰", zodiacGroup = "Water", mbtiGroup = "INTJ"),
                    // Fire星座 - INTJ
                    Answer(content = "你总是充满能量和激情，像一团火焰照亮了你周围的世界。现在是时候将你内心的想法付诸实践，跟随你的直觉，行动起来！", zodiacGroup = "Fire", mbtiGroup = "INTJ"),
                    Answer(content = "内心深处的渴望推动着你，别再犹豫，按照你的直觉行事，勇敢地迈出第一步。", zodiacGroup = "Fire", mbtiGroup = "INTJ"),

                    // Fire星座 - ENFP
                    Answer(content = "外面的世界对你来说是一个充满挑战的舞台，毫不畏惧的你永远准备迎接下一场冒险。相信自己的能力，冒险一步，成就非凡。", zodiacGroup = "Fire", mbtiGroup = "ENFP"),
                    Answer(content = "你善于发现机会并抓住它们。不要犹豫，跟随你内心的声音，你将迎接更多的机遇。", zodiacGroup = "Fire", mbtiGroup = "ENFP"),

                    // Earth星座 - ESTJ
                    Answer(
                        content = "你知道什么是最重要的，并始终朝着目标坚定不移地前行。无论面临何种挑战，你都会用理性和决策力克服困难。",
                        zodiacGroup = "Earth",
                        mbtiGroup = "ESTJ"
                    ),

                    // Earth星座 - ISFP
                    Answer(content = "你关注内心的情感，善于感受周围的美。每一天都值得为自己的梦想而斗，做自己热爱的事情，才是最真实的自我。", zodiacGroup = "Earth", mbtiGroup = "ISFP"),
                    Answer(content = "你温暖、柔和，内心总是渴望表达自己的情感。相信自己，走自己的路，终究能找到属于自己的幸福。", zodiacGroup = "Earth", mbtiGroup = "ISFP"),

                    // Air星座 - ENTJ
                    Answer(content = "你天生是领导者，敢于挑战极限。不断突破自己，带领他人走向成功。你的计划将成为现实。", zodiacGroup = "Air", mbtiGroup = "ENTJ"),
                    Answer(content = "强大的决策能力和坚韧不拔的精神使你成为任何领域的领袖，勇敢地承担责任，你的未来一片光明。", zodiacGroup = "Air", mbtiGroup = "ENTJ"),

                    // Air星座 - ENFJ
                    Answer(content = "你关心他人，总是为他人着想。你不仅能激励自己，也能激励他人向着共同目标前进，成为团队中的核心力量。", zodiacGroup = "Air", mbtiGroup = "ENFJ"),
                    Answer(content = "你的领导力不仅体现在行动上，还在于你对他人感受的关注。你天生具备帮助他人实现目标的能力，继续前行，成功将伴随你。", zodiacGroup = "Air", mbtiGroup = "ENFJ"),

                    // Water星座 - INTJ
                    Answer(content = "你洞察一切，冷静思考。无论挑战如何，你总是能够保持专注，最终找到正确的路径。", zodiacGroup = "Water", mbtiGroup = "INTJ"),
                    Answer(content = "内心的清晰目标驱动着你前行。尽管路径曲折，但你总能通过深思熟虑找到最合适的解决方案。", zodiacGroup = "Water", mbtiGroup = "INTJ"),

                    // Water星座 - INFJ
                    Answer(content = "你总是为他人着想，用心倾听。你的直觉和情感让你在人际关系中建立深厚的联系，继续坚守内心的信念，世界会因为你而变得更加美好。", zodiacGroup = "Water", mbtiGroup = "INFJ"),
                    Answer(content = "你看似安静，但内心的热情如潮水般澎湃。相信自己的直觉，并追随内心的指引，做出你应做的选择。", zodiacGroup = "Water", mbtiGroup = "INFJ"),

                    // Fire星座 - ESTJ
                    Answer(content = "你注重实践，强大的执行力使你在生活和工作中获得巨大成功。继续做你擅长的事情，你的努力必会有所回报。", zodiacGroup = "Fire", mbtiGroup = "ESTJ"),
                    Answer(content = "你始终坚守规则和流程，带领他人踏实前行。保持冷静和理性，成功就在眼前。", zodiacGroup = "Fire", mbtiGroup = "ESTJ"),

                    // Fire星座 - ESFP
                    Answer(content = "你充满活力，总是以积极的态度面对生活中的每一个挑战。享受当下的每一刻，你的乐观会感染他人，成就你无可比拟的魅力。", zodiacGroup = "Fire", mbtiGroup = "ESFP"),
                    Answer(content = "你的社交能力和乐观情绪让你在任何场合都能迅速成为焦点。继续展现你的独特魅力，人生会因此变得更加精彩。", zodiacGroup = "Fire", mbtiGroup = "ESFP"),

                    // Earth星座 - ESTJ
                    Answer(content = "你知道什么是最重要的，并始终朝着目标坚定不移地前行。无论面临何种挑战，你都会用理性和决策力克服困难。", zodiacGroup = "Earth", mbtiGroup = "ESTJ"),
                    Answer(content = "严谨和责任感让你成为团队中的坚实支柱。继续坚守信念，你的努力会为自己和他人带来积极的变化。", zodiacGroup = "Earth", mbtiGroup = "ESTJ"),

                    // Earth星座 - ISFJ
                    Answer(content = "你总是关注他人的需求，耐心且细致。通过关心他人，你不仅帮助了他们，也找到了自己的内心宁静。", zodiacGroup = "Earth", mbtiGroup = "ISFJ"),
                    Answer(content = "温暖的心和关爱他人的力量，让你在任何环境中都能建立起牢固的人际关系。继续照顾自己，也帮助他人走向更好的生活。", zodiacGroup = "Earth", mbtiGroup = "ISFJ"),

                    // Air星座 - ENTP
                    Answer(content = "你充满好奇，总是能发现不同的解决方案和新奇的思路。保持你的创新精神，继续探索未知的领域，成就属于你的一片天地。", zodiacGroup = "Air", mbtiGroup = "ENTP"),
                    Answer(content = "你永远充满激情，直面每一个挑战。把自己的创意付诸实践，世界需要你的创新。", zodiacGroup = "Air", mbtiGroup = "ENTP"),

                    // Air星座 - INTP
                    Answer(
                        content = "你善于深入思考和独立分析。无论问题多么复杂，你总能找到独特的解决方法。保持冷静和理性，未来属于你。",
                        zodiacGroup = "Air",
                        mbtiGroup = "INTP"
                    ),

                    // Water星座 - ISFP
                    Answer(content = "你以温和的方式感知这个世界，善于欣赏美好。通过跟随自己的情感，你找到真正的自己，内心始终清澈。", zodiacGroup = "Water", mbtiGroup = "ISFP"),
                    Answer(content = "你的内心像海洋一样辽阔，充满着情感与感知。无论面对什么选择，跟随内心，世界会因此变得更加美好。", zodiacGroup = "Water", mbtiGroup = "ISFP"),

                    // Water星座 - INFP
                    Answer(content = "你看似安静，但内心总是充满激情与梦想。相信自己的直觉，继续追求内心的信念，你会找到属于自己的道路。", zodiacGroup = "Water", mbtiGroup = "INFP"),
                    Answer(content = "你总是充满理想主义，关注内心的声音。继续追随你的热情，世界会为你打开更多的可能性。", zodiacGroup = "Water", mbtiGroup = "INFP")
                )

                val dao = database.answerDao()
                dao.insertAnswer(defaultAnswers)

                val count = dao.getAnswerCount()
                Log.d("Database", "Inserted $count answers")
            } catch (e: Exception) {
                Log.e("Database", "Error initializing database", e)
            }
        }
    }
}
