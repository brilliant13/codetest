import java.util.*;

public class Test {

    // ===============================================
    // 초기 상태 및 준비
    // ===============================================

    /*
    입력: "011"
    nums = ['0', '1', '1']  (인덱스: 0, 1, 2)
    used = [false, false, false]
    current = ""
    primes = {} (빈 Set)
    */

    // ===============================================
    // 완전한 호출 트리 (들여쓰기로 깊이 표현)
    // ===============================================

    public static void traceCompletely() {
        System.out.println("=== '011' 완전한 호출 추적 ===\n");

        System.out.println("초기 상태:");
        System.out.println("nums = ['0', '1', '1']");
        System.out.println("used = [false, false, false]");
        System.out.println("current = \"\"");
        System.out.println("primes = {}");
        System.out.println();

        System.out.println("📞 호출 시작!\n");

        // 실제 호출 추적
        Set<Integer> primes = new HashSet<>();
        char[] nums = {'0', '1', '1'};
        boolean[] used = new boolean[3];

        generateNumbers(nums, used, "", primes, 0);

        System.out.println("\n🎯 최종 결과: " + primes);
        System.out.println("소수 개수: " + primes.size());
    }

    private static void generateNumbers(char[] nums, boolean[] used, String current,
                                        Set<Integer> primes, int depth) {

        // 들여쓰기로 깊이 표현
        String indent = "  ".repeat(depth);

        System.out.println(indent + "📞 호출 [깊이=" + depth + "]");
        System.out.println(indent + "   current = \"" + current + "\"");
        System.out.println(indent + "   used = " + Arrays.toString(used));

        // 현재 문자열 처리
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            System.out.println(indent + "   숫자 변환: \"" + current + "\" → " + num);

            if (isPrime(num)) {
                primes.add(num);
                System.out.println(indent + "   ✅ " + num + "은 소수! primes에 추가");
                System.out.println(indent + "   📦 primes = " + primes);
            } else {
                System.out.println(indent + "   ❌ " + num + "은 소수 아님");
            }
        } else {
            System.out.println(indent + "   빈 문자열 → 소수 체크 건너뛰기");
        }

        // for 루프 시작
        System.out.println(indent + "   🔄 for 루프 시작 (i = 0 to " + (nums.length-1) + ")");

        for (int i = 0; i < nums.length; i++) {
            System.out.println(indent + "   ├─ i=" + i + ", nums[" + i + "]='" + nums[i] + "'");

            if (!used[i]) {
                System.out.println(indent + "   │  used[" + i + "]=false → 사용 가능!");
                System.out.println(indent + "   │  🔸 used[" + i + "] = true 설정");

                used[i] = true;
                String newCurrent = current + nums[i];

                System.out.println(indent + "   │  📞 재귀 호출: current=\"" + newCurrent + "\"");

                // 재귀 호출
                generateNumbers(nums, used, newCurrent, primes, depth + 1);

                // 되돌아옴
                used[i] = false;
                System.out.println(indent + "   │  🔙 되돌아옴: used[" + i + "] = false");

            } else {
                System.out.println(indent + "   │  used[" + i + "]=true → 이미 사용 중, 건너뛰기");
            }
        }

        System.out.println(indent + "   🔚 for 루프 종료");
        System.out.println(indent + "📤 리턴 [깊이=" + depth + "]");
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // ===============================================
    // 핵심 포인트들 정리
    // ===============================================

    public static void explainKeyPoints() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎯 핵심 포인트들");
        System.out.println("=".repeat(60));

        System.out.println("\n1️⃣ 중복 처리:");
        System.out.println("   - nums[1]='1'과 nums[2]='1'은 다른 위치지만 같은 값");
        System.out.println("   - \"1\", \"11\", \"101\", \"110\" 등이 만들어짐");
        System.out.println("   - 하지만 Set을 사용하므로 중복된 소수는 자동 제거");

        System.out.println("\n2️⃣ 0으로 시작하는 수:");
        System.out.println("   - \"0\", \"01\", \"011\" 등이 만들어짐");
        System.out.println("   - Integer.parseInt(\"01\") = 1");
        System.out.println("   - Integer.parseInt(\"011\") = 11");
        System.out.println("   - 앞의 0은 자동으로 제거됨!");

        System.out.println("\n3️⃣ 백트래킹 과정:");
        System.out.println("   - used[i] = true (선택)");
        System.out.println("   - 재귀 호출 (탐색)");
        System.out.println("   - used[i] = false (되돌리기)");
        System.out.println("   - 이 과정으로 모든 조합을 빠짐없이 탐색");

        System.out.println("\n4️⃣ 부분 문자열 vs 순열:");
        System.out.println("   - 이 알고리즘은 사실상 '부분 순열'을 생성");
        System.out.println("   - 길이 1: \"0\", \"1\", \"1\"");
        System.out.println("   - 길이 2: \"01\", \"10\", \"11\", \"10\", \"11\", \"01\"");
        System.out.println("   - 길이 3: \"011\", \"101\", \"110\", \"011\", \"101\", \"110\"");

        System.out.println("\n5️⃣ 최종 결과:");
        System.out.println("   - 만들어지는 고유한 수: 0, 1, 10, 11, 101, 110");
        System.out.println("   - 이 중 소수: 11, 101");
        System.out.println("   - 답: 2개");
    }

    // ===============================================
    // 간단한 버전 (헷갈리지 않게)
    // ===============================================

    public static void simpleTrace() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🔧 간단한 추적 (핵심만)");
        System.out.println("=".repeat(60));

        System.out.println("\n호출 1: current=\"\" → 빈 문자열");
        System.out.println("├─ i=0: '0' 선택 → 호출 2: current=\"0\"");
        System.out.println("│  ├─ 0은 소수 아님");
        System.out.println("│  ├─ i=1: '1' 선택 → 호출 3: current=\"01\"");
        System.out.println("│  │  ├─ \"01\" → 1, 소수 아님");
        System.out.println("│  │  └─ i=2: '1' 선택 → 호출 4: current=\"011\"");
        System.out.println("│  │     └─ \"011\" → 11, 소수! ✅");
        System.out.println("│  └─ i=2: '1' 선택 → 호출 3: current=\"01\"");
        System.out.println("│     └─ (similar...)");
        System.out.println("├─ i=1: '1' 선택 → 호출 2: current=\"1\"");
        System.out.println("│  ├─ 1은 소수 아님");
        System.out.println("│  ├─ i=0: '0' 선택 → 호출 3: current=\"10\"");
        System.out.println("│  │  └─ \"10\" → 10, 소수 아님");
        System.out.println("│  └─ i=2: '1' 선택 → 호출 3: current=\"11\"");
        System.out.println("│     └─ \"11\" → 11, 소수! ✅");
        System.out.println("└─ i=2: '1' 선택 → 호출 2: current=\"1\"");
        System.out.println("   └─ (i=1과 동일한 과정...)");

        System.out.println("\n🎯 계속해서 101도 찾아집니다!");
    }

    public static void main(String[] args) {
        traceCompletely();
        explainKeyPoints();
        simpleTrace();
    }
}