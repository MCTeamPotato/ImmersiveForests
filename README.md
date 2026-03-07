# ImmersiveForests

**ImmersiveForests** is a simple Minecraft mod that makes trees bigger, fuller, and more impressive — without changing any recipes or game mechanics.

## What It Does

By default, all naturally generated trees are significantly larger than vanilla:

- **Taller trunks** — tree trunks grow about 2× taller, making forests feel genuinely towering
- **Wider canopies** — foliage spreads roughly 1.5× further horizontally, creating dense, lush treetops
- **Fuller crowns** — leaf layers extend higher vertically as well, for a rounder, more natural silhouette
- **Extended leaf decay** — when a tree is cut down, leaves decay over a wider range to match the larger canopy size

All of these values are fully configurable in the config file, so you can dial the size up or down to your preference.

## Optional Features

- **Transparent Leaves** — a config toggle that makes leaves no longer block light, letting sunlight filter through the canopy to the forest floor

## Images
![alt text](images/2026-03-01_02.08.46.png)
![alt text](images/2026-03-01_02.10.05.png)
![alt text](images/2026-03-01_02.13.27.png)
![alt text](images/2026-03-01_02.12.46.png)
![alt text](images/2026-03-01_02.12.38.png)
## Config

The config file immersiveforests.json is generated on first launch and lets you individually adjust:

| Option                      | Default | Description                      |
|-----------------------------|---------|----------------------------------|
| `TrunkBonus`                | 2.0     | Trunk height multiplier          |
| `FoliageHorizontalBonus`    | 1.5     | Canopy width multiplier          |
| `FoliageVerticalBonus`      | 1.5     | Canopy height multiplier         |
| `FoliageDecayRangeBonus`    | 1.5     | Leaf decay distance multiplier   |
| `LeavesNoLongerBlockLight`  | false   | Make leaves transparent to light |

## Note
- The extension may cause unexpected behaviors with mods that make leaf decay faster.
- You won't want to set TrunkBonus too high, as that will make the spruce trees look really hideous.

Accelerated Decay compatibility is already built-in. If you find issues with other mods, feel free to leave a note [here](https://github.com/MCTeamPotato/ImmersiveForests/issues).